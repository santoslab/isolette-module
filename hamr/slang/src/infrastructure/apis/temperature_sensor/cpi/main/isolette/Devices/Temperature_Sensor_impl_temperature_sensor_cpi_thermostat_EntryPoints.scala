// #Sireum

package isolette.Devices

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

object Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_EntryPoints {
  var impl: Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_EntryPointsSig = Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_EntryPointsStub()

  def timeTriggered(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
    impl.timeTriggered(api)
  }

  def activate(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
    impl.activate(api)
  }

  def deactivate(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
    impl.deactivate(api)
  }

  def finalise(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
    impl.finalise(api)
  }

  def initialise(api: isolette.Devices.Temperature_Sensor_impl_Initialization_Api): Unit = {
    impl.initialise(api)
  }

  def recover(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
    impl.recover(api)
  }
}

@msig trait Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_EntryPointsSig {
  def timeTriggered(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit

  def activate(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit

  def deactivate(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit

  def finalise(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit

  def initialise(api: isolette.Devices.Temperature_Sensor_impl_Initialization_Api): Unit

  def recover(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit
}

@record class Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_EntryPointsStub extends Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_EntryPointsSig {
  def stubHalt(): Unit = { halt("Stub implementation of Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_EntryPointsSig") }

  def timeTriggered(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
    stubHalt()
  }

  def activate(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
    stubHalt()
  }

  def deactivate(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
    stubHalt()
  }

  def finalise(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
    stubHalt()
  }

  def initialise(api: isolette.Devices.Temperature_Sensor_impl_Initialization_Api): Unit = {
    stubHalt()
  }

  def recover(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
    stubHalt()
  }
}
