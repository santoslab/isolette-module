// #Sireum

package isolette.Regulate

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

object Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_EntryPoints {
  var impl: Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_EntryPointsSig = Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_EntryPointsStub()

  def timeTriggered(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit = {
    impl.timeTriggered(api)
  }

  def activate(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit = {
    impl.activate(api)
  }

  def deactivate(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit = {
    impl.deactivate(api)
  }

  def finalise(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit = {
    impl.finalise(api)
  }

  def initialise(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Initialization_Api): Unit = {
    impl.initialise(api)
  }

  def recover(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit = {
    impl.recover(api)
  }
}

@msig trait Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_EntryPointsSig {
  def timeTriggered(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit

  def activate(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit

  def deactivate(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit

  def finalise(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit

  def initialise(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Initialization_Api): Unit

  def recover(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit
}

@record class Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_EntryPointsStub extends Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_EntryPointsSig {
  def stubHalt(): Unit = { halt("Stub implementation of Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_EntryPointsSig") }

  def timeTriggered(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit = {
    stubHalt()
  }

  def activate(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit = {
    stubHalt()
  }

  def deactivate(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit = {
    stubHalt()
  }

  def finalise(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit = {
    stubHalt()
  }

  def initialise(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Initialization_Api): Unit = {
    stubHalt()
  }

  def recover(api: isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Operational_Api): Unit = {
    stubHalt()
  }
}
