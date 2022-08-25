// #Sireum #Logika

package isolette.Monitor

import org.sireum._
import isolette._
import isolette.InitialValues
import isolette.Isolette_Data_Model._

// This file will not be overwritten so is safe to edit
object Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface {

  // inputs
  //    current_temperature
  //    monitor_mode
  //    upper_alarm_tempWstatus
  //    lower_alarm_tempWstatus
  //
  // outputs
  //    monitor_status
  //    interface_failure
  //    upper_alarm_temp
  //    lower_alarm_temp

  //======================================
  // Initialize Entry Point
  //======================================

  def initialise(api: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Initialization_Api): Unit = {
    /*
    Contract(
      Modifies(api),
      Ensures(
        (api.lower_alarm_temp == Temp_impl(InitialValues.DEFAULT_LOWER_ALARM_TEMPERATURE)) &
          (api.upper_alarm_temp == Temp_impl(InitialValues.DEFAULT_UPPER_ALARM_TEMPERATURE)) &
          (api.monitor_status == InitialValues.DEFAULT_MONITOR_STATUS) &
          (api.interface_failure == Failure_Flag_impl(InitialValues.DEFAULT_MONITOR_INTERFACE_FAILURE_FLAG))
      )
    )
    */
    // set initial lower desired temp
    api.put_lower_alarm_temp(
      Temp_impl(
        InitialValues.DEFAULT_LOWER_ALARM_TEMPERATURE))
    // For debugging
    // Inline the concrete value (instead of using defined constant, because it doesn't seem that invariants on constants are being enforced)
    // f32"95.0"))
    // set initial upper desired temp
    api.put_upper_alarm_temp(
      Temp_impl(
        InitialValues.DEFAULT_UPPER_ALARM_TEMPERATURE))
    // For debugging
    // Inline the concrete value (instead of using defined constant, because it doesn't seem that invariants on constants are being enforced)
    // f32"101.0"))
    // set initial regulator status
    api.put_monitor_status(InitialValues.DEFAULT_MONITOR_STATUS)
    // set initial regulator failure
    api.put_interface_failure(
      Failure_Flag_impl(
        InitialValues.DEFAULT_MONITOR_INTERFACE_FAILURE_FLAG))
  }

  //======================================
  // Compute Entry Point
  //======================================

  def timeTriggered(api: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = {
    /*
    Contract(
      Modifies(api),
      //  === Monitor Status ===
      //
      //  REQ-MMI-1: If the Manage Monitor Interface mode is INIT,
      //  the Monitor Status shall be set to Init.
      Case("REQ-MMI-1",
        Requires(api.monitor_mode == Monitor_Mode.Init_Monitor_Mode),
        Ensures(api.monitor_status == Status.Init_Status)
      ),
      //  REQ-MMI-2: If the Manage Monitor Interface mode is NORMAL,
      //  the Monitor Status shall be set to On.
      Case("REQ-MMI-2",
        Requires(api.monitor_mode == Monitor_Mode.Normal_Monitor_Mode),
        Ensures(api.monitor_status == Status.On_Status)
      ),
      //  REQ-MMI-3: If the Manage Monitor Interface mode is FAILED,
      //  the Monitor Status shall be set to Failed.
      //  Latency: < Max Operator Response Time
      //  Tolerance: N/A
      Case("REQ-MMI-3",
        Requires(api.monitor_mode == Monitor_Mode.Failed_Monitor_Mode),
        Ensures(api.monitor_status == Status.Failed_Status)
      ),
      //
      //  === Monitor Interface Failure internal variable ===
      //
      //  REQ-MMI-4: If the Status attribute of the Lower Alarm Temperature
      //  or the Upper Alarm Temperature is Invalid,
      //  the Monitor Interface Failure shall be set to True.
      Case("REQ-MMI-4",
        Requires(
          (api.lower_alarm_tempWstatus.status == ValueStatus.Invalid) |
            (api.upper_alarm_tempWstatus.status == ValueStatus.Invalid)
        ),
        Ensures(api.interface_failure.value)
      ),
      //  REQ-MMI-5: If the Status attribute of the Lower Alarm Temperature
      //  and the Upper Alarm Temperature is Valid,
      //  the Monitor Interface Failure shall be set to False.
      Case("REQ-MMI-5",
        Requires(
          (api.lower_alarm_tempWstatus.status == ValueStatus.Valid) &
            (api.upper_alarm_tempWstatus.status == ValueStatus.Valid)
        ),
        Ensures(!api.interface_failure.value)
      ),
      //  === Alarm Range Internal variable ===
      //
      //  REQ-MMI-6: If the Monitor Interface Failure is False,
      //  the Alarm Range variable shall be set to the Desired Temperature Range.
      Case("REQ-MMI-6",
        Requires(!api.interface_failure.value),
        Ensures(
          (api.lower_alarm_temp.value == In(api).lower_alarm_tempWstatus.value) &
            (api.upper_alarm_temp.value == In(api).upper_alarm_tempWstatus.value)
        )
      ),
      //  REQ-MMI-7: If the Monitor Interface Failure is True,
      //  the Alarm Range variable is UNSPECIFIED.
      Case("REQ-MMI-7",
        Requires(api.interface_failure.value),
        Ensures(/* [RP] Alarm range var is LOW/HIGH vars - what does is mean to make these "UNSPECIFIED" */)
      )
    )
    */

    // -------------- Get values of input ports ------------------

    val lower: Isolette_Data_Model.TempWstatus_impl =
      api.get_lower_alarm_tempWstatus().get

    val upper: Isolette_Data_Model.TempWstatus_impl =
      api.get_upper_alarm_tempWstatus().get

    val monitor_mode: Isolette_Data_Model.Monitor_Mode.Type =
      api.get_monitor_mode().get

    val currentTemp: Isolette_Data_Model.TempWstatus_impl =
      api.get_current_tempWstatus().get

    //assert(lower.value >= 92.0f) // should prove valid
    //assert(lower.value < 93.5f) // should prove invalid

    // =============================================
    //  Set values for Monitor Status (Table A-6)
    // =============================================

    var monitor_status: Isolette_Data_Model.Status.Type = Isolette_Data_Model.Status.Init_Status

    monitor_mode match {

      // INIT Mode
      case Isolette_Data_Model.Monitor_Mode.Init_Monitor_Mode =>
        //  REQ-MMI-1: If the Manage Monitor Interface mode is INIT,
        //  the Monitor Status shall be set to Init.
        monitor_status = Isolette_Data_Model.Status.Init_Status

      // NORMAL Mode
      case Isolette_Data_Model.Monitor_Mode.Normal_Monitor_Mode =>
        //  REQ-MMI-2: If the Manage Monitor Interface mode is NORMAL,
        //  the Monitor Status shall be set to On.
        monitor_status = Isolette_Data_Model.Status.On_Status

      // FAILED Mode
      case Isolette_Data_Model.Monitor_Mode.Failed_Monitor_Mode =>
        //  REQ-MMI-3: If the Manage Monitor Interface mode is FAILED,
        //  the Monitor Status shall be set to Failed.
        monitor_status = Isolette_Data_Model.Status.Failed_Status
    }

    api.put_monitor_status(monitor_status)


    // =============================================
    //  Set values for Monitor Interface Failure internal variable
    // =============================================


    // FIXME: I [JMH] believe that these requirements reflect poor design.
    //  I don't even see why alarm temperature values should have a status value.
    //  Input validation should be performed on these values in the operator interface.
    //  Improper values (i.e., values with bad status), should never even be passed here.
    //

    // The interface_failure status defaults to TRUE, which is the safe modality.
    var interface_failure: B = true

    // Extract the value status from both the upper and lower alarm range
    val upper_alarm_status: Isolette_Data_Model.ValueStatus.Type = upper.status
    val lower_alarm_status: Isolette_Data_Model.ValueStatus.Type = lower.status

    // Set the Monitor Interface Failure value based on the status values of the
    //   upper and lower temperature
    if (!(upper_alarm_status == Isolette_Data_Model.ValueStatus.Valid) ||
      !(lower_alarm_status == Isolette_Data_Model.ValueStatus.Valid)) {
      //  REQ-MMI-4: If the Status attribute of the Lower Alarm Temperature
      //  or the Upper Alarm Temperature is Invalid,
      //  the Monitor Interface Failure shall be set to True.
      interface_failure = true
    } else {
      //  REQ-MMI-5: If the Status attribute of the Lower Alarm Temperature
      //  and the Upper Alarm Temperature is Valid,
      //  the Monitor Interface Failure shall be set to False.
      interface_failure = false
    }

    // create the appropriately typed value to send on the output port and set the port value
    var interface_failure_flag =  Isolette_Data_Model.Failure_Flag_impl(interface_failure)
    api.put_interface_failure(interface_failure_flag)


    // =============================================
    //  Set values for Alarm Range internal variable
    // =============================================

    if (!interface_failure) {
      //  REQ-MMI-6: If the Monitor Interface Failure is False,
      //  the Alarm Range variable shall be set to the Desired Temperature Range.


      api.put_lower_alarm_temp(Isolette_Data_Model.Temp_impl(lower.value))
      api.put_upper_alarm_temp(Isolette_Data_Model.Temp_impl(upper.value))
    } else {
      //  REQ-MMI-7: If the Monitor Interface Failure is True,
      //  the Alarm Range variable is UNSPECIFIED.
      //  [RP] Values from initialization should be maintained here, but are not. Putting default values to skirt error
      //       while running unit test - should really be putting an "UNSPECIFIED" value.

      //assert(InitialValues.DEFAULT_LOWER_ALARM_TEMPERATURE != 95.0f)   //...inserting for debugging

      api.put_lower_alarm_temp(Isolette_Data_Model.Temp_impl(InitialValues.DEFAULT_LOWER_ALARM_TEMPERATURE))
      api.put_upper_alarm_temp(Isolette_Data_Model.Temp_impl(InitialValues.DEFAULT_UPPER_ALARM_TEMPERATURE))
    }
  }

  def activate(api: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = { }

  def deactivate(api: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = { }

  def finalise(api: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = { }

  def recover(api: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = { }
}
