// #Sireum #Logika

package isolette.Monitor

import org.sireum._
import isolette._

// This file will not be overwritten so is safe to edit
object Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm {

  //  Input ports:
  //    monitor_mode
  //    lower_alarm_temperature
  //    upper_alarm_temperature
  //    current_temperature
  //
  //  Output ports:
  //    alarm_control
  //
  //  Flows
  //    [Function: Manage Alarm]
  //

  //======================================
  // Persistent component state
  //======================================

  // FIXME: confirm that having "lastCmd" for alarm set default to "Off" is OK
  var lastCmd: Isolette_Data_Model.On_Off.Type = Isolette_Data_Model.On_Off.Off

  //======================================
  // Initialize Entry Point
  //======================================

  def initialise(api: Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Initialization_Api): Unit = {
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
      Modifies(lastCmd, api),
      Ensures(lastCmd == Isolette_Data_Model.On_Off.Off, api.alarm_control == Isolette_Data_Model.On_Off.Off)
    )
    */
    lastCmd = Isolette_Data_Model.On_Off.Off
    //  REQ-MA-1: If the Monitor Mode is INIT, the Alarm Control shall be set
    //    to Off.
    api.put_alarm_control(Isolette_Data_Model.On_Off.Off)
  }

  //======================================
  // Compute Entry Point
  //======================================
  def timeTriggered(api: Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Operational_Api): Unit = {
    /*
    Contract(
      // ToDo: Need to account for constraints (assumptions) on lower and upper alarm bounds (which
      //   apply for all cases.
      //   The contracts already verify without those assumptions, but we should add them for completeness.
      Modifies(api, lastCmd),
      // Requirements for Manage Alarm (MA)
      //
      //
      //  REQ-MA-1: If the Monitor Mode is INIT, the Alarm Control shall be set
      //    to Off.
      Case("REQ-MA-1",
        Requires(api.monitor_mode == Isolette_Data_Model.Monitor_Mode.Init_Monitor_Mode),
        Ensures(
          api.alarm_control == Isolette_Data_Model.On_Off.Off,
          lastCmd == Isolette_Data_Model.On_Off.Off
        )
      ),
      //  REQ-MA-2: If the Monitor Mode is NORMAL and the Current Temperature is
      //  less than the Lower Alarm Temperature or greater than the Upper Alarm
      //    Temperature, the Alarm Control shall be set to On.
      Case("REQ-MA-2",
        Requires(
          api.monitor_mode == Isolette_Data_Model.Monitor_Mode.Normal_Monitor_Mode,
          api.current_tempWstatus.value < api.lower_alarm_temp.value |
            api.current_tempWstatus.value > api.upper_alarm_temp.value
        ),
        Ensures(
          api.alarm_control == Isolette_Data_Model.On_Off.Onn,
          lastCmd == Isolette_Data_Model.On_Off.Onn
        )
      ),
      //  REQ-MA-3: If the Monitor Mode is NORMAL and the Current Temperature
      //    is greater than or equal to the Lower Alarm Temperature and less than
      //  the Lower Alarm Temperature +0.5 degrees, or the Current Temperature is
      //  greater than the Upper Alarm Temperature -0.5 degrees and less than or equal
      //  to the Upper Alarm Temperature, the value of the Alarm Control shall
      //  not be changed.
      Case("REQ-MA-3",
        Requires(
          api.monitor_mode == Isolette_Data_Model.Monitor_Mode.Normal_Monitor_Mode,
          (api.current_tempWstatus.value >= api.lower_alarm_temp.value &
            api.current_tempWstatus.value < api.lower_alarm_temp.value + 0.5f) |
            (api.current_tempWstatus.value > api.upper_alarm_temp.value - 0.5f &
              api.current_tempWstatus.value <= api.upper_alarm_temp.value)
        ),
        Ensures(
          api.alarm_control == In(lastCmd),
          lastCmd == In(lastCmd)
        )
      ),
      //    REQ-MA-4: If the Monitor Mode is NORMAL and the value of the Current
      //    Temperature is greater than or equal to the Lower Alarm Temperature
      //  +0.5 degrees and less than or equal to the Upper Alarm Temperature
      //    -0.5 degrees, the Alarm Control shall be set to Off.
      Case("REQ-MA-4",
        Requires(
          api.monitor_mode == Isolette_Data_Model.Monitor_Mode.Normal_Monitor_Mode,
          // api.current_tempWstatus.value >= api.lower_alarm_temp.value + 0.5f |  // bug
          api.current_tempWstatus.value >= api.lower_alarm_temp.value + 0.5f &
            api.current_tempWstatus.value <= api.upper_alarm_temp.value - 0.5f
        ),
        Ensures(
          api.alarm_control == Isolette_Data_Model.On_Off.Off,
          lastCmd == Isolette_Data_Model.On_Off.Off
        )
      ),
      //  REQ-MA-5: If the Monitor Mode is FAILED, the Alarm Control shall be
      //  set to On.
      Case("REQ-MA-5",
        Requires(api.monitor_mode == Isolette_Data_Model.Monitor_Mode.Failed_Monitor_Mode),
        Ensures(
          api.alarm_control == Isolette_Data_Model.On_Off.Onn,
          lastCmd == Isolette_Data_Model.On_Off.Onn
        )
      )
    )
    */
    // -------------- Get values of input ports ------------------

    val lower: Isolette_Data_Model.Temp_impl =
      api.get_lower_alarm_temp().get

    val upper: Isolette_Data_Model.Temp_impl =
      api.get_upper_alarm_temp().get

    val monitor_mode: Isolette_Data_Model.Monitor_Mode.Type =
      api.get_monitor_mode().get

    val currentTemp: Isolette_Data_Model.TempWstatus_impl =
      api.get_current_tempWstatus().get

    // debugging - check effectiveness of input constraint (value should be >= 68.0f)
    // assert(currentTemp.value > 65.0f)
    // or, an alternative form
    // Deduce(
    //  |- (currentTemp.value > 65.0f)
    // )


    //==============================================================================

    // current command defaults to value of last command
    var currentCmd: Isolette_Data_Model.On_Off.Type = lastCmd

    // address all cases of monitor_mode: Init, Normal, Failed
    monitor_mode match {

      // INIT Mode
      case Isolette_Data_Model.Monitor_Mode.Init_Monitor_Mode =>
        //  REQ-MA-1: If the Monitor Mode is INIT, the Alarm Control shall be set
        //    to Off
        currentCmd = Isolette_Data_Model.On_Off.Off

      // NORMAL Mode
      case Isolette_Data_Model.Monitor_Mode.Normal_Monitor_Mode =>
        //  REQ-MA-2: If the Monitor Mode is NORMAL and the Current Temperature is
        //  less than the Lower Alarm Temperature or greater than the Upper Alarm
        //    Temperature, the Alarm Control shall be set to On.
        if ((currentTemp.value < lower.value) || currentTemp.value > upper.value) {
          currentCmd = Isolette_Data_Model.On_Off.Onn
        } else
        //  REQ-MA-3: If the Monitor Mode is NORMAL and the
        //    [cond1]
        //      Current Temperature is greater than or equal to the Lower Alarm Temperature
        //      and less than the Lower Alarm Temperature +0.5 degrees,
        //   or [cond2]
        //      the Current Temperature is greater than the Upper Alarm Temperature -0.5 degrees
        //      and less than or equal to the Upper Alarm Temperature,
        //   the value of the Alarm Control shall not be changed.
          if (   ((currentTemp.value >= lower.value) && (currentTemp.value < lower.value + 0.5f))   // [cond1]
            // || ((currentTemp.value > upper.value + 0.5f) && (currentTemp.value <= upper.value + 0.5f))) // [cond2]  // bug
            || ((currentTemp.value > upper.value - 0.5f) && (currentTemp.value <= upper.value))) // [cond2]
          {
            currentCmd = lastCmd
          } else
          //    REQ-MA-4: If the Monitor Mode is NORMAL and the value of the Current Temperature is
          //       [cond3] >= to the Lower Alarm Temperature +0.5 degrees
          //   and [cond4] <= to the Upper Alarm Temperature -0.5 degrees,
          //   the Alarm Control shall be set to Off.
            if (   (currentTemp.value >= (lower.value + 0.5f))
              && (currentTemp.value <= (upper.value - 0.5f))
            ) {
              currentCmd = Isolette_Data_Model.On_Off.Off
            }
      // Note: there are probably going to be issues in proving the exhaustiveness of these cases above due
      // floating point rounding issues, and I don't know how to handle that.

      // FAILED Mode
      case Isolette_Data_Model.Monitor_Mode.Failed_Monitor_Mode =>
        //  REQ-MA-5: If the Monitor Mode is FAILED, the Alarm Control shall be
        //  set to On.
        currentCmd = Isolette_Data_Model.On_Off.Onn
    }

    api.put_alarm_control(currentCmd)
    lastCmd = currentCmd
  }

  //===========================================================================================
  // Experiment with proving disjointness and completeness of requirements cases MA2, MA3, MA4
  //===========================================================================================

  @strictpure def caseMA2(lower: Isolette_Data_Model.Temp_impl, upper: Isolette_Data_Model.Temp_impl,
                          currentTemp: Isolette_Data_Model.TempWstatus_impl): B = {
    currentTemp.value < lower.value || currentTemp.value > upper.value
  }

  @strictpure def caseMA3(lower: Isolette_Data_Model.Temp_impl, upper: Isolette_Data_Model.Temp_impl,
                          currentTemp: Isolette_Data_Model.TempWstatus_impl): B = {
    ((currentTemp.value >= lower.value) && (currentTemp.value < lower.value + 0.5f)) ||
      ((currentTemp.value > upper.value - 0.5f) && (currentTemp.value <= upper.value))
  }

  @strictpure def caseMA4(lower: Isolette_Data_Model.Temp_impl, upper: Isolette_Data_Model.Temp_impl,
                          currentTemp: Isolette_Data_Model.TempWstatus_impl): B = {
    currentTemp.value >= (lower.value + 0.5f) && currentTemp.value <= (upper.value - 0.5f)
  }

  def conditions(lower: Isolette_Data_Model.Temp_impl, upper: Isolette_Data_Model.Temp_impl,
                 currentTemp: Isolette_Data_Model.TempWstatus_impl): Unit = {
    // non-overlapping
    Deduce(
      lower.value + 0.5f < upper.value |- ( !(caseMA2(lower, upper, currentTemp) & caseMA3(lower, upper, currentTemp)))
    )
    Deduce(
      lower.value + 0.5f < upper.value |- ( !(caseMA2(lower, upper, currentTemp) & caseMA4(lower, upper, currentTemp)))
    )
    Deduce(
      lower.value + 0.5f < upper.value |- ( !(caseMA3(lower, upper, currentTemp) & caseMA4(lower, upper, currentTemp)))
    )
    // complete
    Deduce(
      lower.value + 0.5f < upper.value |- (caseMA2(lower, upper, currentTemp) | caseMA3(lower, upper, currentTemp) | caseMA4(lower, upper, currentTemp))
    )
  }


  def activate(api: Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Operational_Api): Unit = { }

  def deactivate(api: Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Operational_Api): Unit = { }

  def finalise(api: Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Operational_Api): Unit = { }

  def recover(api: Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Operational_Api): Unit = { }
}
