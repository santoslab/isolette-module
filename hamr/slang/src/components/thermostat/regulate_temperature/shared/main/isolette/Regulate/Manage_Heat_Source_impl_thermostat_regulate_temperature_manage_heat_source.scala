// #Sireum

package isolette.Regulate

import org.sireum._
import isolette._

// This file will not be overwritten so is safe to edit
object Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source {

  //======================================
  // Persistent component state
  //======================================

  // ToDo: Consider the extent to which this component local state needs to be
  //   declared at the AADL or the extent to which it might need to be exposed to
  //   support system-level proofs.
  //
  // TODO: The following is a known issue that we will likly only resolve via
  //   user documentation, but keep this text here to inform the reader of this
  //   code until documentation can be completed.
  //    ==>
  //   There is a bit of a conceptual glitch here since following the
  //   AADL model of computation we should initialize all values
  //   in the initialization entry point.
  //   There should be no notion of initializing execution outside of the
  //   initialise method.  However, Scala/Slang requires that all variables
  //   are required to be initialized at the point of declaration,
  //   so we must have initialization here, which probably leads
  //   to some notion of initializing code outside of the AADL computational
  //   model.   We should check the implications of that.
  //   For now, we initialize both when variable is declared and in the initialize
  //   entry point.
  //
  // FIXME: confirm that having "lastCmd" for heat source set to "Off" is OK
  var lastCmd: Isolette_Data_Model.On_Off.Type = Isolette_Data_Model.On_Off.Off

  //======================================
  // Initialize Entry Point
  //======================================

  def initialise(api: Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Initialization_Api): Unit = {
    /*
    Contract(
      // ToDo: we need to be able eventually to specify that specific ports were
      //   modified.  In the Slang representation, that corresponds to specifying
      //   that certain (spec) fields of the 'api' structure are modified.
      //   We don't have the capability now, so we have to say that the entire
      //   api structure (including all spec variables is modified).  More precise
      //   constraints would need to be given in the post-condition.
      //
      // ToDo: Elsewhere, we would be setting the initial mode to INIT, so
      //  I assume that the connection between the initial INIT mode and the
      //  OFF command would be detected at the system proof level.
      Modifies(api,lastCmd),
      Ensures(api.heat_control == Isolette_Data_Model.On_Off.Off &
        lastCmd == Isolette_Data_Model.On_Off.Off))
    */
    lastCmd = Isolette_Data_Model.On_Off.Off
    // REQ-MHS-1: If the Regulator Mode is INIT, the Heat Control shall be
    // set to Off
    val currentCmd = Isolette_Data_Model.On_Off.Off
    api.put_heat_control(currentCmd)
  }

  //======================================
  // Compute Entry Point
  //======================================

  def timeTriggered(api: Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Operational_Api): Unit = {
    //  Latency: < Allowed Heat Source Latency

    // Note:  There are multiple possible styles for formalizing the requirements above.
    //  Of course, the contracts will ultimately be generated from the AADL, and there
    //  we will multiple styles for formalizing things at the AADL level:
    //    (a) behavioral guarantees written as conjunctions of implications (one conjunct
    //        for each requirement above)
    //    (b) ..written as contract cases (one case for each requirement above)
    //    (c) ..one case per mode, with specific situations within a mode written as
    //          implications.
    //  We use style (b) below because we can use the name/tag of each case to establish
    //  traceability to the requirements.
    /*
    Contract(
      Modifies(api,lastCmd),
      // REQ-MHS-1: If the Regulator Mode is INIT, the Heat Control shall be
      // set to Off.
      Case(
        "REQ-MHS-1",
        // Note: may need to put parens around arguments of ->: due to Scala parsing limitations
        Requires(api.regulator_mode == Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode),
        Ensures(api.heat_control == Isolette_Data_Model.On_Off.Off &
          lastCmd == Isolette_Data_Model.On_Off.Off)),
      // Note: Alternate form -- need to discuss/document trade-offs of using implication
      //  guards instead of contract cases
      // Ensures((In(api.regulator_mode) == Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode)
      //            ->: (api.heat_control == Isolette_Data_Model.On_Off.Off))
      //
      // REQ-MHS-2: If the Regulator Mode is NORMAL and the Current Temperature is less than
      // the Lower Desired Temperature, the Heat Control shall be set to On.
      Case(
        "Req-MHS-2",
        Requires(api.regulator_mode == Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode
          // and the Current Temperature is less than the Lower Desired Temperature
          & api.current_tempWstatus.value < api.lower_desired_temp.value),
        Ensures(api.heat_control == Isolette_Data_Model.On_Off.Onn &
          lastCmd == Isolette_Data_Model.On_Off.Onn)),
      //
      // REQ-MHS-3: If the Regulator Mode is NORMAL and the Current Temperature is greater than
      // the Upper Desired Temperature, the Heat Control shall be set to Off.
      Case(
        "Req-MHS-3",
        Requires(api.regulator_mode == Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode
          // and the Current Temperature is greater than the Upper Desired Temperature,
          & api.current_tempWstatus.value > api.upper_desired_temp.value),
        Ensures(api.heat_control == Isolette_Data_Model.On_Off.Off &
          lastCmd == Isolette_Data_Model.On_Off.Off)),
      //
      // REQ-MHS-4: If the Regulator Mode is NORMAL and the Current
      // Temperature is greater than or equal to the Lower Desired Temperature
      // and less than or equal to the Upper Desired Temperature, the value of
      // the Heat Control shall not be changed.
      Case(
        "Req-MHS-4",
        Requires(api.regulator_mode == Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode
          // the Current Temperature is greater than or equal to the Lower Desired Temperature
          // and less than or equal to the Upper Desired Temperature
          & api.current_tempWstatus.value >= api.lower_desired_temp.value
          & api.current_tempWstatus.value <= api.upper_desired_temp.value),
        Ensures(api.heat_control == In(lastCmd) &
          In(lastCmd) == lastCmd)),
      //
      // REQ-MHS-5: If the Regulator Mode is FAILED, the Heat Control shall be
      // set to Off.
      Case(
        "Req-MHS-5",
        Requires(api.regulator_mode == Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode),
        Ensures(api.heat_control == Isolette_Data_Model.On_Off.Off &
          lastCmd == Isolette_Data_Model.On_Off.Off))
    )
    */
    // -------------- Get values of input ports ------------------

    // lower desired temperature
    val lower: Isolette_Data_Model.Temp_impl =
      api.get_lower_desired_temp().get

    // upper desired temperature
    val upper: Isolette_Data_Model.Temp_impl =
      api.get_upper_desired_temp().get

    // regulator mode
    val regulator_mode : Isolette_Data_Model.Regulator_Mode.Type =
      api.get_regulator_mode().get

    // current temperature with status
    val currentTemp : Isolette_Data_Model.TempWstatus_impl =
      api.get_current_tempWstatus().get

    //================ compute / control logic ===========================

    // assert(lower.value == 96.0f) // Should prove invalid

    // current command defaults to value of last command (REQ-MHS-4)
    var currentCmd: Isolette_Data_Model.On_Off.Type = lastCmd
    // Deduce( |- (currentCmd == Isolette_Data_Model.On_Off.Onn))  // should fail, and it does fail

    regulator_mode match {

      // ----- INIT Mode --------
      case Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode =>
        // REQ-MHS-1
        currentCmd = Isolette_Data_Model.On_Off.Off

      // ------ NORMAL Mode -------
      case Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode =>

        if (currentTemp.value > upper.value) {
          // REQ-MHS-3
          currentCmd = Isolette_Data_Model.On_Off.Off
        } else if (currentTemp.value < lower.value) {
          // REQ-MHS-2
          // currentCmd = Isolette_Data_Model.On_Off.Off // seeded bug/error
          currentCmd = Isolette_Data_Model.On_Off.Onn
        }

      // otherwise currentCmd defaults to lastCmd (REQ-MHS-4)

      // ------ FAILED Mode -------
      case Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode =>
        // REQ-MHS-5
        currentCmd = Isolette_Data_Model.On_Off.Off
    }

    // -------------- Set values of output ports ------------------

    api.put_heat_control(currentCmd)
    // api.put_heat_control(Isolette_Data_Model.On_Off.Off)  // seeded bug/error
    // Deduce( |- (api.heat_control == Isolette_Data_Model.On_Off.Onn))  // should fail
    lastCmd = currentCmd
    // Deduce( |- (lastCmd == Isolette_Data_Model.On_Off.Onn))  // should fail
  }

  def activate(api: Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Operational_Api): Unit = { }

  def deactivate(api: Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Operational_Api): Unit = { }

  def finalise(api: Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Operational_Api): Unit = { }

  def recover(api: Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Operational_Api): Unit = { }
}
