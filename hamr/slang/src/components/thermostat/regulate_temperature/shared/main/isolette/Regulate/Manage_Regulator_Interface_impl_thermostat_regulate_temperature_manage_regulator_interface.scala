// #Sireum #Logika

package isolette.Regulate

import org.sireum._
import isolette._

// This file will not be overwritten so is safe to edit
object Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface {

  //   Inputs
  //    lower_desired_temp
  //    upper_desired_temp
  //    current_temperature
  //    regulator_mode
  //
  //   Outputs
  //     regulator_status
  //     displayed_temp
  //     interface_failure

  //  def ScalaRound(t : Option[Isolette_Data_Model.TempWstatus_impl]): Isolette_Data_Model.Temp_impl = {
  //    if(t.isEmpty) {
  //      Isolette_Data_Model.Temp_impl(value = scala.Float.NaN)
  //    } else {
  //      Isolette_Data_Model.Temp_impl(value = Math.round(t.get().value.value))
  //    }
  //  }

  //  @strictpure def Round(t : Option[Isolette_Data_Model.TempWstatus_impl]): Isolette_Data_Model.Temp_impl = {
  //     ... write pure scala function for rounding
  //  }

  // FIXME: hack of initialization of data port values due lack of proper protocol for thread/port initialization
  // Default lower and upper desired temperatures.
  // Used as a hack because we don't have a proper method for initialization of thread states and port values yet
  val LOW: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_LOWER_DESIRED_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)
  val HIGH: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_UPPER_DESIRED_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)
  // val DEFAULT_MODE: Isolette_Data_Model.Regulator_Mode.Type = Isolette_Data_Model.Regulator_Mode.Init
  // val DEFAULT_TEMP: Isolette_Data_Model.TempWstatus = Isolette_Data_Model.TempWstatus(InitialValues.DEFAULT_CURRENT_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)

  //======================================
  // Initialize Entry Point
  //======================================

  def initialise(api: Manage_Regulator_Interface_impl_Initialization_Api): Unit = {
    /*
    Contract(
      Modifies(api),
      Ensures(api.lower_desired_temp.value == InitialValues.DEFAULT_LOWER_DESIRED_TEMPERATURE &
        api.upper_desired_temp.value == InitialValues.DEFAULT_UPPER_DESIRED_TEMPERATURE &
        api.displayed_temp.value == InitialValues.DEFAULT_DISPLAYED_TEMPERATURE &
        api.regulator_status == InitialValues.DEFAULT_REGULATOR_STATUS &
        api.interface_failure.value == InitialValues.DEFAULT_REGULATOR_INTERNAL_FAILURE_FLAG
      )
    )
    */
    // set initial lower desired temp
    api.put_lower_desired_temp(
      Isolette_Data_Model.Temp_impl(
        InitialValues.DEFAULT_LOWER_DESIRED_TEMPERATURE))
    // set initial upper desired temp
    api.put_upper_desired_temp(
      Isolette_Data_Model.Temp_impl(
        InitialValues.DEFAULT_UPPER_DESIRED_TEMPERATURE))
    // set initial displayed temp
    api.put_displayed_temp(
      Isolette_Data_Model.Temp_impl(
        InitialValues.DEFAULT_DISPLAYED_TEMPERATURE))
    // set initial regulator status
    api.put_regulator_status(
      InitialValues.DEFAULT_REGULATOR_STATUS)
    // set initial regulator failure
    api.put_interface_failure(
      Isolette_Data_Model.Failure_Flag_impl(
        InitialValues.DEFAULT_REGULATOR_INTERNAL_FAILURE_FLAG))
  }

  //======================================
  // Compute Entry Point
  //======================================

  def timeTriggered(api: Manage_Regulator_Interface_impl_Operational_Api): Unit = {

    // place holder for global/component in/out declarations,
    // which should reference port variables defined in bridge and any user declared component persistent state

    // place holder for derives/info flow clauses, which should align with info flows at the AADL level

    // place holder for data policy clauses
    //   (for this component, we can illustrate this by validation of the desired temperature)
    //   by requiring desired temperature to be authorized.
    //   Other options might include some constraints on the temp sensor data, e.g., sufficient fidelity
    //
    // NOTE:  This thread computes two independent functions:
    //   (1) The value for regulator status, and
    //   (2) The value of the display temperature.
    //   (3) The value of the regulator interface failure status
    //
    // For that reason, the Contract Cases doesn't result in a nice specification organization,
    // since the cases must be mutually exclusive (though that is not enforced in Logika at the moment).
    // The organization would be problematic because there is no way to easily specify the cases
    // for functions (1), (2), and (3) in a mutually exclusive fashion.  Specifically, the
    // intuitive desired format would be that there is case for function (1) is satisfied AND
    // a case for function (2) is satisfied and a case for function (3) is satisfied,
    // but three cases being satisfied on the same dispatch
    // is not mutually exclusive.   Therefore, specifying the contract using **implications** to
    // guard the "cases" for each function is a better match.
    //
    // NOTE: One subtle with the "implication" approach described above is that since we currently
    //  can't specify the fact that input ports are read-only and can't change their value during
    //  the computation AND since the Ensures clause by default refers to values in the post-state,
    //  we must explicitly add frame-conditions indicating that the value of input ports does not
    //  change OR we need to reference the pre-state value of input ports using In(..) in the clauses
    //  representing requirements.  We don't need to worry about this type of issue in the Case contract
    //  notation because Requires clauses naturally reference the pre-state values of ports.
    //
    //  We illustrate the explicit reference of pre-state values using In(..) below.
    /*
    Contract(
      Modifies(api),
      // Ensures(
      //
      // == Function (1): Regulator Status ==
      //
      // REQ-MRI-1: If the Regulator Mode is INIT,
      //   the Regulator Status shall be set to Init.
      Case("REQ-MRI-1",
        Requires(api.regulator_mode == Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode),
        Ensures(api.regulator_status == Isolette_Data_Model.Status.Init_Status)
      ),
      //        (In(api).regulator_mode == Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode)
      //          ->: (api.regulator_status == Isolette_Data_Model.Status.Init_Status),
      // NOTE: using the alternate approach for reference pre-state input port values if we don't
      // have frame-conditions, we would write
      // (In(api).regulator_mode == Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode)
      //    ->: (api.regulator_status == Isolette_Data_Model.Status.Init_Status),

      // REQ-MRI-2: If the Regulator Mode is NORMAL,
      //   the Regulator Status shall be set to On.
      Case("REQ-MRI-2",
        Requires(api.regulator_mode == Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode),
        Ensures(api.regulator_status == Isolette_Data_Model.Status.On_Status)
      ),
      //       (In(api).regulator_mode == Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode)
      //         ->: (api.regulator_status == Isolette_Data_Model.Status.On_Status),
      // REQ-MRI-3: If the Regulator Mode is FAILED,
      //   the Regulator Status shall be set to Failed.
      Case("REQ-MRI-3",
        Requires(api.regulator_mode == Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode),
        Ensures(api.regulator_status == Isolette_Data_Model.Status.Failed_Status)
      ),
      //       (In(api).regulator_mode == Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode)
      //         ->: (api.regulator_status == Isolette_Data_Model.Status.Failed_Status)
      //
      // Latency: < Max Operator Response Time
      // Tolerance: N/A

      // == Function (2): Display Temperature ==
      //
      // REQ-MRI-4: If the Regulator Mode is NORMAL, the
      //  Display Temperature shall be set to the value of the
      //  Current Temperature rounded to the nearest integer.
      //  ToDo:  Implement rounding requirement
      //
      Case("REQ-MRI-4",
        Requires(api.regulator_mode == Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode),
        Ensures(api.displayed_temp == Isolette_Data_Model.Temp_impl(api.current_tempWstatus.value))
      ),
      //        (In(api).regulator_mode == Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode)
      //          ->: (api.displayed_temp == Isolette_Data_Model.Temp_impl(api.current_tempWstatus.value)),
      // REQ-MRI-5:
      //  If the Regulator Mode is not NORMAL,
      //  the value of the Display Temperature is UNSPECIFIED.
      //
      //  NOTE:  There is no need to directly specify this requirement (i.e., to specify what happens
      //  to the display temp when the regulator mode is specified.  From the point of view of Logika,
      //  the display_temp value is simply unconstrained.
      //
      //  However, if we eventually support Parnas-table-like concepts we might want to have some explict
      //    representation of the !NORMAL case so that we can demonstrate that we have exhaustively considered
      //    all cases.
      //
      // Latency: < Max Operator Response Time
      // Tolerance: +/- 0.6 degrees F
      //
      // == Function (3): Regulator Interface Failure ==
      //
      // REQ-MRI-6: If the Status attribute of the Lower Desired Temperature
      // or the Upper Desired Temperature is Invalid,
      // the Regulator Interface Failure shall be set to True.
      Case("REQ-MRI-6",
        Requires(api.lower_desired_tempWstatus.status != Isolette_Data_Model.ValueStatus.Valid |
          api.upper_desired_tempWstatus.status != Isolette_Data_Model.ValueStatus.Valid),
        Ensures(api.interface_failure.value == T)
      ),
      //        (In(api).lower_desired_tempWstatus.status == Isolette_Data_Model.ValueStatus.Invalid |
      //          In(api).upper_desired_tempWstatus.status == Isolette_Data_Model.ValueStatus.Invalid)
      //          ->: (api.interface_failure.value == T),
      //
      // REQ-MRI-7: If the Status attribute of the Lower Desired Temperature
      // and the Upper Desired Temperature is Valid,
      // the Regulator Interface Failure shall be set to False.
      Case("REQ-MRI-7_and_8",
        Requires(api.lower_desired_tempWstatus.status == Isolette_Data_Model.ValueStatus.Valid &
          api.upper_desired_tempWstatus.status == Isolette_Data_Model.ValueStatus.Valid),
        Ensures(api.interface_failure.value == F,
          api.lower_desired_temp.value == In(api).lower_desired_tempWstatus.value,
          api.upper_desired_temp.value == In(api).upper_desired_tempWstatus.value)
      )
      //        (In(api).lower_desired_tempWstatus.status == Isolette_Data_Model.ValueStatus.Valid &
      //          In(api).upper_desired_tempWstatus.status == Isolette_Data_Model.ValueStatus.Valid)
      //          ->: (api.interface_failure.value == F),
      //
      // == Desired Range ===
      //
      // REQ-MRI-8: If the Regulator Interface Failure is False,
      // the Desired Range shall be set to the Desired Temperature Range.
      //
      //        (api.interface_failure.value == F)
      //          // NOTE: interface_failure is an output port and so we need to refer to it in the post-state
      //          //  as constrained by the clauses above.  Therefore, we do not use In(api).interface_failure
      //          ->: (api.lower_desired_temp.value == In(api).lower_desired_tempWstatus.value &
      //                api.upper_desired_temp.value == In(api).upper_desired_tempWstatus.value))
      // REQ-MRI-9: If the Regulator Interface Failure is True,
      // the Desired Range is UNSPECIFIED.
      //      ) // end Ensures
    ) // end Contract
    */
    // -------------- Get values of input ports ------------------

    val lower: Isolette_Data_Model.TempWstatus_impl =
      api.get_lower_desired_tempWstatus().get
    // remove code for old approach that lacked initializers
    // api.getlower_desired_tempWstatus().getOrElseEager(LOW)

    val upper: Isolette_Data_Model.TempWstatus_impl =
      api.get_upper_desired_tempWstatus().get
    // remove code for old approach that lacked initializers
    // api.getupper_desired_tempWstatus().getOrElseEager(HIGH)

    val regulator_mode: Isolette_Data_Model.Regulator_Mode.Type =
      api.get_regulator_mode().get
    // remove code for old approach that lacked initializers
    // api.getregulator_mode().getOrElseEager(DEFAULT_MODE)

    val currentTemp: Isolette_Data_Model.TempWstatus_impl =
      api.get_current_tempWstatus().get
    // remove code for old approach that lacked initializers
    // api.getcurrent_tempWstatus().getOrElseEager(DEFAULT_TEMP)

    // =============================================
    //  Set values for Regulator Status (Table A-6)
    // =============================================

    var regulator_status: Isolette_Data_Model.Status.Type = Isolette_Data_Model.Status.Init_Status

    regulator_mode match {


      // =============================================
      //  Set values for Regulator Status
      // =============================================

      // Note that this code computes a function that is independent of the other
      // aspects of this thread.  This should be reflected in flow declarations.

      // INIT Mode
      case Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode =>
        // REQ-MRI-1: If the Regulator Mode is INIT,
        //   the Regulator Status shall be set to Init.
        regulator_status = Isolette_Data_Model.Status.Init_Status

      // NORMAL Mode
      case Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode =>
        // REQ-MRI-2: If the Regulator Mode is NORMAL,
        //   the Regulator Status shall be set to On.
        // regulator_status = Isolette_Data_Model.Status.Failed_Status // Seeded error / bug
        regulator_status = Isolette_Data_Model.Status.On_Status

      // FAILED Mode
      case Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode =>
        // REQ-MRI-3: If the Regulator Mode is FAILED,
        //   the Regulator Status shall be set to Failed.
        // regulator_status = Isolette_Data_Model.Status.On_Status   // Seeded error / bug
        regulator_status = Isolette_Data_Model.Status.Failed_Status
    }

    api.put_regulator_status(regulator_status)

    // =============================================
    //  Set values for Display Temperature (Table A-6)
    // =============================================

    // Latency: < Max Operator Response Time
    // Tolerance: +/- 0.6 degrees F
    //

    // FIXME: Develop better way to assigning final value to display temperature that
    //        doesn't involve selecting an arbitrary default temperature.
    var display_temperature =
    Isolette_Data_Model.Temp_impl(InitialValues.DEFAULT_DISPLAYED_TEMPERATURE)

    regulator_mode match {
      // NORMAL Mode
      case Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode =>
        // REQ-MRI-4: If the Regulator Mode is NORMAL, the
        //  Display Temperature shall be set to the value of the
        //  Current Temperature rounded to the nearest integer.
        // FIXME: add rounding, which is currently omitted
        display_temperature = Isolette_Data_Model.Temp_impl(currentTemp.value)

      // INIT, FAILED Modes

      // REQ-MRI-5:
      //  If the Regulator Mode is not NORMAL,
      //  the value of the Display Temperature is UNSPECIFIED.
      //
      // leave the current temperature set to the default temperature value above.
      // This fulfills the requirement since the value when the Regulator Mode is not NORMAL
      // is unspecified.

      case Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode =>    // Do nothing
      case Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode =>  // Do nothing
    }

    //api.put_displayed_temp(Isolette_Data_Model.Temp_impl(42.0f)) // should fail
    api.put_displayed_temp(display_temperature) // keep this live when testing above assertion so the contract postcondition doesn't fail first and supress this

    // =============================================
    //  Set values for Regulator Interface Failure internal variable
    // =============================================


    //
    // REQ-MRI-7: If the Status attribute of the Lower Desired Temperature
    // and the Upper Desired Temperature is Valid,
    // the Regulator Interface Failure shall be set to False.

    // FIXME:
    //  I [JMH] believe that these requirements reflect poor design.
    //  I don't even see why desired temperature values should have a status value.
    //  Input validation should be performed on these values in the operator interface.
    //  Improper values (i.e., values with bad status), should never even be passed here.

    // The interface_failure status defaults to TRUE (i.e., failing), which is the safe modality.
    var interface_failure: B = true

    // Extract the value status from both the upper and lower alarm range
    val upper_desired_temp_status: Isolette_Data_Model.ValueStatus.Type = upper.status
    val lower_desired_temp_status: Isolette_Data_Model.ValueStatus.Type = lower.status

    // Set the Monitor Interface Failure value based on the status values of the
    //   upper and lower temperature
    if (!(upper_desired_temp_status == Isolette_Data_Model.ValueStatus.Valid) ||
      !(lower_desired_temp_status == Isolette_Data_Model.ValueStatus.Valid)) {
      // REQ-MRI-6: If the Status attribute of the Lower Desired Temperature
      // or the Upper Desired Temperature is Invalid,
      // the Regulator Interface Failure shall be set to True.
      interface_failure = true
    } else {
      // REQ-MRI-7: If the Status attribute of the Lower Desired Temperature
      // and the Upper Desired Temperature is Valid,
      // the Regulator Interface Failure shall be set to False.
      interface_failure = false
    }

    // create the appropriately typed value to send on the output port and set the port value
    var interface_failure_flag =  Isolette_Data_Model.Failure_Flag_impl(interface_failure)
    api.put_interface_failure(interface_failure_flag)


    // =============================================
    //  Set values for Desired Range internal variable
    // =============================================

    // REQ-MRI-9: If the Regulator Interface Failure is True,
    // the Desired Range is UNSPECIFIED.

    // FIXME:
    //   What to do for unspecified case

    if (!interface_failure) {
      // REQ-MRI-8: If the Regulator Interface Failure is False,
      // the Desired Range shall be set to the Desired Temperature Range.
      api.put_lower_desired_temp(Isolette_Data_Model.Temp_impl(lower.value))
      api.put_upper_desired_temp(Isolette_Data_Model.Temp_impl(upper.value))
    } else {
      // FIXME: The requirement is that the values should be unspecified.
      //  For now, set the values to the default values from the initial values file.
      //  We may need to have a discussion to confirm that this is acceptable.
      // Avoid using the Float.NaN because that value is in Scala but not Slang
      // api.put_lower_desired_temp(Isolette_Data_Model.Temp_impl(Float.NaN))
      // api.put_upper_desired_temp(Isolette_Data_Model.Temp_impl(Float.NaN))
      api.put_lower_desired_temp(
        Isolette_Data_Model.Temp_impl(InitialValues.DEFAULT_LOWER_DESIRED_TEMPERATURE))
      api.put_upper_desired_temp(
        Isolette_Data_Model.Temp_impl(InitialValues.DEFAULT_UPPER_ALARM_TEMPERATURE))
    }
  }

  def activate(api: Manage_Regulator_Interface_impl_Operational_Api): Unit = { }

  def deactivate(api: Manage_Regulator_Interface_impl_Operational_Api): Unit = { }

  def finalise(api: Manage_Regulator_Interface_impl_Operational_Api): Unit = { }

  def recover(api: Manage_Regulator_Interface_impl_Operational_Api): Unit = { }
}
