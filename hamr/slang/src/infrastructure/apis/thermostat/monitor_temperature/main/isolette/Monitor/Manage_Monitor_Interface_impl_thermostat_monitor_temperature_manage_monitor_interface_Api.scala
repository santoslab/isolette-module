// #Sireum

package isolette.Monitor

import org.sireum._
import art._
import isolette._

@sig trait Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Api {
  def id: Art.BridgeId
  def upper_alarm_tempWstatus_Id : Art.PortId
  def lower_alarm_tempWstatus_Id : Art.PortId
  def current_tempWstatus_Id : Art.PortId
  def monitor_mode_Id : Art.PortId
  def upper_alarm_temp_Id : Art.PortId
  def lower_alarm_temp_Id : Art.PortId
  def monitor_status_Id : Art.PortId
  def interface_failure_Id : Art.PortId

  def put_upper_alarm_temp(value : Isolette_Data_Model.Temp_impl) : Unit = {
    Art.putValue(upper_alarm_temp_Id, Isolette_Data_Model.Temp_impl_Payload(value))
  }

  def put_lower_alarm_temp(value : Isolette_Data_Model.Temp_impl) : Unit = {
    Art.putValue(lower_alarm_temp_Id, Isolette_Data_Model.Temp_impl_Payload(value))
  }

  def put_monitor_status(value : Isolette_Data_Model.Status.Type) : Unit = {
    Art.putValue(monitor_status_Id, Isolette_Data_Model.Status_Payload(value))
  }

  def put_interface_failure(value : Isolette_Data_Model.Failure_Flag_impl) : Unit = {
    Art.putValue(interface_failure_Id, Isolette_Data_Model.Failure_Flag_impl_Payload(value))
  }

  def logInfo(msg: String): Unit = {
    Art.logInfo(id, msg)
  }

  def logDebug(msg: String): Unit = {
    Art.logDebug(id, msg)
  }

  def logError(msg: String): Unit = {
    Art.logError(id, msg)
  }
}

@datatype class Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Initialization_Api (
  val id: Art.BridgeId,
  val upper_alarm_tempWstatus_Id : Art.PortId,
  val lower_alarm_tempWstatus_Id : Art.PortId,
  val current_tempWstatus_Id : Art.PortId,
  val monitor_mode_Id : Art.PortId,
  val upper_alarm_temp_Id : Art.PortId,
  val lower_alarm_temp_Id : Art.PortId,
  val monitor_status_Id : Art.PortId,
  val interface_failure_Id : Art.PortId) extends Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Api

@datatype class Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api (
  val id: Art.BridgeId,
  val upper_alarm_tempWstatus_Id : Art.PortId,
  val lower_alarm_tempWstatus_Id : Art.PortId,
  val current_tempWstatus_Id : Art.PortId,
  val monitor_mode_Id : Art.PortId,
  val upper_alarm_temp_Id : Art.PortId,
  val lower_alarm_temp_Id : Art.PortId,
  val monitor_status_Id : Art.PortId,
  val interface_failure_Id : Art.PortId) extends Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Api {

  def get_upper_alarm_tempWstatus() : Option[Isolette_Data_Model.TempWstatus_impl] = {
    val value : Option[Isolette_Data_Model.TempWstatus_impl] = Art.getValue(upper_alarm_tempWstatus_Id) match {
      case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port upper_alarm_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
        None[Isolette_Data_Model.TempWstatus_impl]()
      case _ => None[Isolette_Data_Model.TempWstatus_impl]()
    }
    return value
  }

  def get_lower_alarm_tempWstatus() : Option[Isolette_Data_Model.TempWstatus_impl] = {
    val value : Option[Isolette_Data_Model.TempWstatus_impl] = Art.getValue(lower_alarm_tempWstatus_Id) match {
      case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port lower_alarm_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
        None[Isolette_Data_Model.TempWstatus_impl]()
      case _ => None[Isolette_Data_Model.TempWstatus_impl]()
    }
    return value
  }

  def get_current_tempWstatus() : Option[Isolette_Data_Model.TempWstatus_impl] = {
    val value : Option[Isolette_Data_Model.TempWstatus_impl] = Art.getValue(current_tempWstatus_Id) match {
      case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port current_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
        None[Isolette_Data_Model.TempWstatus_impl]()
      case _ => None[Isolette_Data_Model.TempWstatus_impl]()
    }
    return value
  }

  def get_monitor_mode() : Option[Isolette_Data_Model.Monitor_Mode.Type] = {
    val value : Option[Isolette_Data_Model.Monitor_Mode.Type] = Art.getValue(monitor_mode_Id) match {
      case Some(Isolette_Data_Model.Monitor_Mode_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port monitor_mode.  Expecting 'Isolette_Data_Model.Monitor_Mode_Payload' but received ${v}")
        None[Isolette_Data_Model.Monitor_Mode.Type]()
      case _ => None[Isolette_Data_Model.Monitor_Mode.Type]()
    }
    return value
  }
}
