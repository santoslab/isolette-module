// #Sireum #Logika

package isolette.Regulate

import org.sireum._
import isolette._
import isolette.Isolette_Data_Model.ValueStatus

// This file will not be overwritten so is safe to edit
object Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode {

  // Define function capturing init mode time out condition as defined in FAA REMH
  //   Figure A-4 and Table A-9
  //
  // FIXME: simulate check of Manage_Regulator_Mode initial value timeout constraint
  //  Currently, set the timeout condition to TRUE -- meaning that we have waited
  //  long enough for the system temperatures to stabilize.
  //  This means that interface failures and valid temperature failures will NOT
  //  be masked.
  @strictpure def timeout_condition_satisfied(): B = { return true }

  //======================================
  // Persistent component state
  //======================================

  var regulator_mode : Isolette_Data_Model.Regulator_Mode.Type = Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode
  var isFirstInvocation : B = true

  //======================================
  // Initialize Entry Point
  //======================================

  def initialise(api: Manage_Regulator_Mode_impl_Initialization_Api): Unit = {
    // TODO: There is a bit of a conceptual glitch here since following the
    //   AADL model of computation we should initialize all values here --
    //   There should be no notion of initializing execution outside of the
    //   initialise method.  However, Scala/Slang requires that all variables
    //   are required to be initialized at the point of declaration,
    //   so we must have initialization elsewhere, which probably leads
    //   to some notion of initializing code outside of the AADL computational
    //   model.   We should check the implications of that.
    /*
    Contract(
      Modifies(api,regulator_mode,isFirstInvocation),
      Ensures(api.regulator_mode == Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode &
        regulator_mode == Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode &
        isFirstInvocation))
     */
    regulator_mode = Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode
    isFirstInvocation = true
    api.put_regulator_mode(regulator_mode)
  }

  //======================================
  // Compute Entry Point
  //======================================

  def timeTriggered(api: Manage_Regulator_Mode_impl_Operational_Api): Unit = {
    /*
    Contract(
      Modifies(api, regulator_mode,isFirstInvocation),
      // input ports:
      //   current_temperature
      //   interface_failure
      //   internal_failure
      // output ports:
      //   regulator_mode
      //
      // Requirements for Manage Regulator Mode (MRM)
      //
      //   These requirements are what is implied by the mode transition diagram in
      //   the FAA REMH Figure A-4
      //
      // == Initial Mode ==
      //
      // REQ-MRM-1: Upon the first dispatch of the thread, the regulator mode is Init.
      Case("REQ-MRM-1",
        Requires(isFirstInvocation),
        Ensures(regulator_mode == Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode &
          !isFirstInvocation)
      ),
      //
      // == Transitions from Init mode ==
      //
      Case("REQ-MRM_2",
        // REQ-MRM-2: If the current regulator mode is Init, then
        Requires(regulator_mode == Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode & !isFirstInvocation),
        //   the regulator mode is set to NORMAL iff the regulator status is valid (see Table A-10), i.e.,
        //     if  NOT (Regulator Interface Failure OR Regulator Internal Failure)
        //         AND Current Temperature.Status = Valid
        Ensures((api.interface_failure.value != T & api.internal_failure.value != T & api.current_tempWstatus.status == ValueStatus.Valid) ===
          (regulator_mode == Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode))
      ),
      Case("REQ-MRM-3",
        // REQ-MRM-3: If the current regulator mode is Init, then
        Requires(regulator_mode == Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode),
        //     the regulator mode is set to Failed iff the time during
        //     which the thread has been in Init mode exceeds the
        //     Regulator Init Timeout value.
        Ensures(timeout_condition_satisfied() === (regulator_mode == Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode))
      ),
      // ==  Transitions from Normal mode ==
      //
      Case("REQ-MRM-4",
        // REQ-MRM-4: If the current regulator mode is Normal, then
        Requires(regulator_mode == Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode),
        //     the regulator mode is set to Failed iff
        //     the regulator status is false, i.e.,
        //       if  (Regulator Interface Failure OR Regulator Internal Failure)
        //           OR NOT(Current Temperature.Status = Valid)
        Ensures((api.interface_failure.value == T | api.internal_failure.value == T | api.current_tempWstatus.status != ValueStatus.Valid) ===
          (regulator_mode == Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode))
      ),
    )
    */
    // -------------- Get values of input ports ------------------

    val current_tempWstatus: Isolette_Data_Model.TempWstatus_impl =
      api.get_current_tempWstatus().get
    //  -- old code used before initialization methods
    // api.getcurrent_tempWstatus().getOrElseEager(DEFAULT_TEMPWSTATUS)
    val  current_temperature_status: Isolette_Data_Model.ValueStatus.Type = current_tempWstatus.status

    val interface_failure: Isolette_Data_Model.Failure_Flag_impl =
      api.get_interface_failure().get
    //  -- old code used before initialization methods
    // api.getinterface_failure().getOrElseEager(DEFAULT_INTERFACE_FAILURE)

    // FIXME: hack to fix missing connection
    //  When connection is added, the initial value should be
    //  set in the initialize entry point for Detect_Regulator_Failure
    val internal_failure : Isolette_Data_Model.Failure_Flag_impl =
    // api.getinternal_failure().get() -- fails due to a missing connection
    api.get_internal_failure().getOrElseEager(
      Isolette_Data_Model.Failure_Flag_impl(InitialValues.DEFAULT_REGULATOR_INTERNAL_FAILURE_FLAG))

    //==============================================================================


    // determine regulator status as specified in FAA REMH Table A-10
    //  regulator_status = NOT (Monitor Interface Failure OR Monitor Internal Failure)
    //                          AND Current Temperature.Status = Valid
    val regulator_status : B =
    (!(interface_failure.value || internal_failure.value)
      && (current_temperature_status == Isolette_Data_Model.ValueStatus.Valid))

    regulator_mode match {

      // Transitions from INIT Mode
      case Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode =>

        // REQ-MRM-2: If the current regulator mode is Init, then
        //   the regulator mode is set to NORMAL iff the regulator status is true, i.e.,
        //     if  NOT (Monitor Interface Failure OR Monitor Internal Failure)
        //         AND Current Temperature.Status = Valid
        if (regulator_status) {
          regulator_mode = Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode
        }

        // REQ-MRM-3: If the current regulator mode is Init, then
        //     the regulator mode is set to Failed iff the time during
        //     which the thread has been in Init mode exceeds the
        //     Regulator Init Timeout value.
        if (!regulator_status && timeout_condition_satisfied()) {
          regulator_mode = Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode
        }

      // otherwise we stay in Init mode

      // Transitions from NORMAL Mode
      case Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode =>

        // REQ-MRM-4: If the current regulator mode is Normal, then
        //     the regulator mode is set to Failed iff
        //     the regulator status is false, i.e.,
        //       if  (Monitor Interface Failure OR Monitor Internal Failure)
        //           OR NOT(Current Temperature.Status = Valid)

        if (!regulator_status) {
          regulator_mode = Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode
        }

      // Transitions from FAILED Mode (do nothing -- system must be rebooted)
      case Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode =>
      // do nothing
    }

    api.put_regulator_mode(regulator_mode)
    isFirstInvocation = false
  }

  def activate(api: Manage_Regulator_Mode_impl_Operational_Api): Unit = { }

  def deactivate(api: Manage_Regulator_Mode_impl_Operational_Api): Unit = { }

  def finalise(api: Manage_Regulator_Mode_impl_Operational_Api): Unit = { }

  def recover(api: Manage_Regulator_Mode_impl_Operational_Api): Unit = { }
}
