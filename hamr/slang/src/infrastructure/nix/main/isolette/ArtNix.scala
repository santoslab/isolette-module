// #Sireum

package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object ArtNix {

  val maxPortIds: Art.PortId = IPCPorts.Main + 1
  val timeTriggered: TimeTriggered = TimeTriggered()
  val noData: Option[DataContent] = None()
  val data: MS[Art.PortId, Option[DataContent]] = MS.create(maxPortIds, noData)
  val connection: MS[Art.PortId, ISZ[(Art.PortId, Art.PortId)]] = {
    val r = MS.create[Art.PortId, ISZ[(Art.PortId, Art.PortId)]](maxPortIds, ISZ())

    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface.displayed_temp.id) = ISZ(
      (IPCPorts.operator_interface_thread_impl_operator_interface_oip_oit_App, Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.display_temperature.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface.regulator_status.id) = ISZ(
      (IPCPorts.operator_interface_thread_impl_operator_interface_oip_oit_App, Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.regulator_status.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source.heat_control.id) = ISZ(
      (IPCPorts.Heat_Source_impl_heat_source_cpi_heat_controller_App, Arch.isolette_single_sensor_Instance_heat_source_cpi_heat_controller.heat_control.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm.alarm_control.id) = ISZ(
      (IPCPorts.operator_interface_thread_impl_operator_interface_oip_oit_App, Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.alarm_control.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface.monitor_status.id) = ISZ(
      (IPCPorts.operator_interface_thread_impl_operator_interface_oip_oit_App, Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.monitor_status.id)
    )
    r(Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.lower_desired_tempWstatus.id) = ISZ(
      (IPCPorts.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface.lower_desired_tempWstatus.id)
    )
    r(Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.upper_desired_tempWstatus.id) = ISZ(
      (IPCPorts.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface.upper_desired_tempWstatus.id)
    )
    r(Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.lower_alarm_tempWstatus.id) = ISZ(
      (IPCPorts.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface.lower_alarm_tempWstatus.id)
    )
    r(Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.upper_alarm_tempWstatus.id) = ISZ(
      (IPCPorts.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface.upper_alarm_tempWstatus.id)
    )
    r(Arch.isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.current_tempWstatus.id) = ISZ(
      (IPCPorts.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface.current_tempWstatus.id),
      (IPCPorts.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm.current_tempWstatus.id),
      (IPCPorts.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode.current_tempWstatus.id),
      (IPCPorts.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface.current_tempWstatus.id),
      (IPCPorts.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source.current_tempWstatus.id),
      (IPCPorts.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode.current_tempWstatus.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface.upper_desired_temp.id) = ISZ(
      (IPCPorts.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source.upper_desired_temp.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface.lower_desired_temp.id) = ISZ(
      (IPCPorts.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source.lower_desired_temp.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface.interface_failure.id) = ISZ(
      (IPCPorts.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode.interface_failure.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode.regulator_mode.id) = ISZ(
      (IPCPorts.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface.regulator_mode.id),
      (IPCPorts.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source.regulator_mode.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface.upper_alarm_temp.id) = ISZ(
      (IPCPorts.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm.upper_alarm_temp.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface.lower_alarm_temp.id) = ISZ(
      (IPCPorts.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm.lower_alarm_temp.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface.interface_failure.id) = ISZ(
      (IPCPorts.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode.interface_failure.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode.monitor_mode.id) = ISZ(
      (IPCPorts.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface.monitor_mode.id),
      (IPCPorts.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm.monitor_mode.id)
    )

    r
  }
  val eventInPorts: MS[Z, Art.PortId] = MSZ(
  )
  var frozen: MS[Art.PortId, Option[DataContent]] = MS.create(maxPortIds, noData)
  var outgoing: MS[Art.PortId, Option[DataContent]] = MS.create(maxPortIds, noData)
  var isTimeDispatch: B = F

  def updateData(port: Art.PortId, d: DataContent): Unit = {
    data(port) = Some(d)
  }

  def timeDispatch(): Unit = {
    isTimeDispatch = T
  }

  def eventDispatch(): Unit = {
    isTimeDispatch = F
  }

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    if (isTimeDispatch) {
      return timeTriggered
    } else {
      var r = ISZ[Art.PortId]()
      for (i <- eventInPorts if data(i).nonEmpty) {
        r = r :+ i
      }
      return EventTriggered(r)
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    frozen = data
    for (i <- eventPortIds) {
      data(i) = noData
    }
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    outgoing(portId) = Some(data)
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    return frozen(portId)
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    for (p <- dataPortIds) {
      outgoing(p) match {
        case Some(d) =>
          outgoing(p) = noData
          for(e <- connection(p)){
            Platform.sendAsync(e._1, e._2, d)
          }
        case _ =>
      }
    }

    for (p <- eventPortIds) {
      outgoing(p) match {
        case Some(d) =>
          outgoing(p) = noData
          for(e <- connection(p)){
            Platform.sendAsync(e._1, e._2, d)
          }
        case _ =>
      }
    }
  }

  def logInfo(title: String, msg: String): Unit = {
    print(title)
    print(": ")
    println(msg)
  }

  def logError(title: String, msg: String): Unit = {
    eprint(title)
    eprint(": ")
    eprintln(msg)
  }

  def logDebug(title: String, msg: String): Unit = {
    print(title)
    print(": ")
    println(msg)
  }

  def time(): Art.Time = {
    return Process.time()
  }

  def run(): Unit = {}

  def tearDownSystemState(): Unit = {}

  def setUpSystemState(): Unit = {}

  def initializePhase(): Unit = {}

  def computePhase(): Unit = {}

  def finalizePhase(): Unit = {}
}