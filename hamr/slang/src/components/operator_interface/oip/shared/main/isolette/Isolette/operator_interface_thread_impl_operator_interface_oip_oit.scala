// #Sireum

package isolette.Isolette

import org.sireum._
import isolette._
import UserInterface.Interface

// This file will not be overwritten so is safe to edit
object operator_interface_thread_impl_operator_interface_oip_oit {

  // Define initial values here because they are used in both
  val initLowerDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_LOWER_DESIRED_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)
  val initUpperDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_UPPER_DESIRED_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)
  val initLowerAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_LOWER_ALARM_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)
  val initUpperAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_UPPER_ALARM_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)

  // Set values for "previous state" based on default values in InitialValues system configuration file
  var lastLowerDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_LOWER_DESIRED_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)
  var lastUpperDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_UPPER_DESIRED_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)
  var lastLowerAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_LOWER_ALARM_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)
  var lastUpperAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_UPPER_ALARM_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)

  //======================================
  // Initialize Entry Point
  //======================================

  var firstInvocation: B = T

  def initialise(api: operator_interface_thread_impl_Initialization_Api): Unit = {
    api.put_lower_desired_tempWstatus(initLowerDesiredTempWstatus)
    api.put_upper_desired_tempWstatus(initUpperDesiredTempWstatus)
    api.put_lower_alarm_tempWstatus(initLowerAlarmTempWstatus)
    api.put_upper_alarm_tempWstatus(initUpperAlarmTempWstatus)
  }

  def timeTriggered(api: operator_interface_thread_impl_Operational_Api): Unit = {

    if(firstInvocation) {
      Interface.initialise(
        lastLowerDesiredTempWstatus, lastUpperDesiredTempWstatus,
        lastLowerAlarmTempWstatus, lastUpperAlarmTempWstatus)
      firstInvocation = F
    }

    // send to interface
    Interface.setRegulatorStatus(api.get_regulator_status())

    Interface.setMonitorStatus(api.get_monitor_status())

    Interface.setDispayTemperature(api.get_display_temperature())

    Interface.setAlarmControl(api.get_alarm_control())


    // fetch from interface
    val ldt = Interface.getLowerDesiredTempWstatus()
    if(ldt != lastLowerDesiredTempWstatus) {
      api.put_lower_desired_tempWstatus(ldt)
      lastLowerDesiredTempWstatus = ldt
    }

    val udt = Interface.getUpperDesiredTempWstatus()
    if(udt != lastUpperDesiredTempWstatus) {
      api.put_upper_desired_tempWstatus(udt)
      lastUpperDesiredTempWstatus = udt
    }

    val lat = Interface.getLowerAlarmTempWstatus()
    if(lat != lastLowerAlarmTempWstatus) {
      api.put_lower_alarm_tempWstatus(lat)
      lastLowerAlarmTempWstatus = lat
    }

    val uat = Interface.getUpperAlarmTempWstatus()
    if(uat != lastUpperAlarmTempWstatus) {
      api.put_upper_alarm_tempWstatus(uat)
      lastUpperAlarmTempWstatus = uat
    }
  }

  def activate(api: operator_interface_thread_impl_Operational_Api): Unit = { }

  def deactivate(api: operator_interface_thread_impl_Operational_Api): Unit = { }

  def finalise(api: operator_interface_thread_impl_Operational_Api): Unit = {
    Interface.finalise()
  }

  def recover(api: operator_interface_thread_impl_Operational_Api): Unit = { }
}
