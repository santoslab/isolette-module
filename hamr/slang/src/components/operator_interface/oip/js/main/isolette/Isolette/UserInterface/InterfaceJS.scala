package isolette.Isolette.UserInterface

import isolette.Isolette_Data_Model
import isolette.Isolette_Data_Model.ValueStatus
import org.scalajs.dom
import org.scalajs.dom.{Event, document}
import org.sireum._

class InterfaceJS extends InterfaceI {

  var lowerDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl = _
  var upperDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl = _
  var lowerAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl = _
  var upperAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl = _

  var ldt: dom.html.Input = _
  var udt: dom.html.Input = _
  var lat: dom.html.Input = _
  var uat: dom.html.Input = _

  var rs: dom.html.Input = _
  var ms: dom.html.Input = _
  var ct: dom.html.Input = _
  var alarm: dom.html.Input = _

  def initialise(_lowerDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl,
                 _upperDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl,
                 _lowerAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl,
                 _upperAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl): Unit = {
    lowerDesiredTempWstatus = _lowerDesiredTempWstatus
    upperDesiredTempWstatus = _upperDesiredTempWstatus
    lowerAlarmTempWstatus = _lowerAlarmTempWstatus
    upperAlarmTempWstatus = _upperAlarmTempWstatus

    def fetch(s: String): dom.html.Input = {
      return document.getElementById(s.native).asInstanceOf[dom.html.Input]
    }

    rs = fetch("regulator_status")
    ms = fetch("monitor_status")
    ct = fetch("current_temperature")
    alarm = fetch("alarm")

    ldt = fetch("lower_desired_temperature")
    udt = fetch("upper_desired_temperature")
    lat = fetch("lower_alarm_temperature")
    uat = fetch("upper_alarm_temperature")

    ldt.value = lowerDesiredTempWstatus.value.toString()
    udt.value = upperDesiredTempWstatus.value.toString()
    lat.value = lowerAlarmTempWstatus.value.toString()
    uat.value = upperAlarmTempWstatus.value.toString()

    ldt.oninput = (_: Event) => {
      lowerDesiredTempWstatus = Isolette_Data_Model.TempWstatus_impl(value = ldt.value.toInt, status = ValueStatus.Valid)
    }

    udt.oninput = (_: Event) => {
      upperDesiredTempWstatus = Isolette_Data_Model.TempWstatus_impl(value = udt.value.toInt, status = ValueStatus.Valid)
    }

    lat.oninput = (_: Event) => {
      lowerAlarmTempWstatus = Isolette_Data_Model.TempWstatus_impl(value = lat.value.toInt, status = ValueStatus.Valid)
    }


    uat.oninput = (_: Event) => {
      upperAlarmTempWstatus = Isolette_Data_Model.TempWstatus_impl(value = uat.value.toInt, status = ValueStatus.Valid)
    }
  }

  def setupUI(): Unit = {
  }

  def finalise(): Unit = {}

  def setRegulatorStatus(v: Option[Isolette_Data_Model.Status.Type]): Unit = {
    if(v.nonEmpty){
      rs.innerText = v.get.toString
    }
  }

  def setMonitorStatus(v: Option[Isolette_Data_Model.Status.Type]): Unit = {
    if(v.nonEmpty) {
      ms.innerText = v.get.toString
    }
  }

  def setDispayTemperature(v: Option[Isolette_Data_Model.Temp_impl]): Unit = {
    if(v.nonEmpty) {
      ct.innerText = v.get.value.toString
    }
  }

  def setAlarmControl(v: Option[Isolette_Data_Model.On_Off.Type]): Unit = {
    if(v.nonEmpty) {
      alarm.innerText = v.get.toString
    }
  }

  def getLowerDesiredTempWstatus(): Isolette_Data_Model.TempWstatus_impl = {
    return lowerDesiredTempWstatus
  }

  def getUpperDesiredTempWstatus(): Isolette_Data_Model.TempWstatus_impl = {
    return upperDesiredTempWstatus
  }

  def getLowerAlarmTempWstatus(): Isolette_Data_Model.TempWstatus_impl = {
    return lowerAlarmTempWstatus
  }

  def getUpperAlarmTempWstatus(): Isolette_Data_Model.TempWstatus_impl = {
    return upperAlarmTempWstatus
  }
}
