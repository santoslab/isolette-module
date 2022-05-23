package isolette.Isolette.UserInterface

import org.sireum._
import org.sireum.$internal.###
import isolette.Isolette_Data_Model

object Interface_Ext {

  var interfaceI: InterfaceI = _

  def initialise(_lowerDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl,
                 _upperDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl,
                 _lowerAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl,
                 _upperAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl): Unit = {
    interfaceI.initialise(
      _lowerDesiredTempWstatus, _upperDesiredTempWstatus,
      _lowerAlarmTempWstatus, _upperAlarmTempWstatus)
  }

  def finalise(): Unit = {
    interfaceI.finalise()
  }

  def setRegulatorStatus(v: Option[Isolette_Data_Model.Status.Type]): Unit = {
    interfaceI.setRegulatorStatus(v)
  }

  def setMonitorStatus(v: Option[Isolette_Data_Model.Status.Type]): Unit = {
    interfaceI.setMonitorStatus(v)
  }

  def setDispayTemperature(v: Option[Isolette_Data_Model.Temp_impl]): Unit = {
    interfaceI.setDispayTemperature(v)
  }

  def setAlarmControl(v: Option[Isolette_Data_Model.On_Off.Type]): Unit = {
    interfaceI.setAlarmControl(v)
  }

  def getLowerDesiredTempWstatus(): Isolette_Data_Model.TempWstatus_impl = {
    return interfaceI.getLowerDesiredTempWstatus()
  }

  def getUpperDesiredTempWstatus(): Isolette_Data_Model.TempWstatus_impl = {
    return interfaceI.getUpperDesiredTempWstatus()
  }

  def getLowerAlarmTempWstatus(): Isolette_Data_Model.TempWstatus_impl = {
    return interfaceI.getLowerAlarmTempWstatus()
  }

  def getUpperAlarmTempWstatus(): Isolette_Data_Model.TempWstatus_impl = {
    return interfaceI.getUpperAlarmTempWstatus()
  }
}

trait InterfaceI {
  def initialise(_lowerDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl,
                 _upperDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl,
                 _lowerAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl,
                 _upperAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl): Unit

  def finalise(): Unit

  def setRegulatorStatus(v: Option[Isolette_Data_Model.Status.Type]): Unit

  def setMonitorStatus(v: Option[Isolette_Data_Model.Status.Type]): Unit

  def setDispayTemperature(v: Option[Isolette_Data_Model.Temp_impl]): Unit

  def setAlarmControl(v: Option[Isolette_Data_Model.On_Off.Type]): Unit

  def getLowerDesiredTempWstatus(): Isolette_Data_Model.TempWstatus_impl

  def getUpperDesiredTempWstatus(): Isolette_Data_Model.TempWstatus_impl

  def getLowerAlarmTempWstatus(): Isolette_Data_Model.TempWstatus_impl

  def getUpperAlarmTempWstatus(): Isolette_Data_Model.TempWstatus_impl
}