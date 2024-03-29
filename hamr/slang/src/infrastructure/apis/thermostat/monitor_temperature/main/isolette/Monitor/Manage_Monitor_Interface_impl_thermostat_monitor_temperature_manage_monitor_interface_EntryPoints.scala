// #Sireum

package isolette.Monitor

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

object Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_EntryPoints {
  var impl: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_EntryPointsSig = Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_EntryPointsStub()

  def timeTriggered(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = {
    impl.timeTriggered(api)
  }

  def activate(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = {
    impl.activate(api)
  }

  def deactivate(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = {
    impl.deactivate(api)
  }

  def finalise(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = {
    impl.finalise(api)
  }

  def initialise(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Initialization_Api): Unit = {
    impl.initialise(api)
  }

  def recover(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = {
    impl.recover(api)
  }
}

@msig trait Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_EntryPointsSig {
  def timeTriggered(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit

  def activate(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit

  def deactivate(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit

  def finalise(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit

  def initialise(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Initialization_Api): Unit

  def recover(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit
}

@record class Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_EntryPointsStub extends Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_EntryPointsSig {
  def stubHalt(): Unit = { halt("Stub implementation of Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_EntryPointsSig") }

  def timeTriggered(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = {
    stubHalt()
  }

  def activate(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = {
    stubHalt()
  }

  def deactivate(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = {
    stubHalt()
  }

  def finalise(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = {
    stubHalt()
  }

  def initialise(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Initialization_Api): Unit = {
    stubHalt()
  }

  def recover(api: isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Operational_Api): Unit = {
    stubHalt()
  }
}
