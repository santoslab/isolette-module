// #Sireum

package isolette.Devices

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

object Heat_Source_impl_heat_source_cpi_heat_controller_EntryPoints {
  var impl: Heat_Source_impl_heat_source_cpi_heat_controller_EntryPointsSig = Heat_Source_impl_heat_source_cpi_heat_controller_EntryPointsStub()

  def timeTriggered(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit = {
    impl.timeTriggered(api)
  }

  def activate(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit = {
    impl.activate(api)
  }

  def deactivate(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit = {
    impl.deactivate(api)
  }

  def finalise(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit = {
    impl.finalise(api)
  }

  def initialise(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Initialization_Api): Unit = {
    impl.initialise(api)
  }

  def recover(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit = {
    impl.recover(api)
  }
}

@msig trait Heat_Source_impl_heat_source_cpi_heat_controller_EntryPointsSig {
  def timeTriggered(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit

  def activate(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit

  def deactivate(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit

  def finalise(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit

  def initialise(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Initialization_Api): Unit

  def recover(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit
}

@record class Heat_Source_impl_heat_source_cpi_heat_controller_EntryPointsStub extends Heat_Source_impl_heat_source_cpi_heat_controller_EntryPointsSig {
  def stubHalt(): Unit = { halt("Stub implementation of Heat_Source_impl_heat_source_cpi_heat_controller_EntryPointsSig") }

  def timeTriggered(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit = {
    stubHalt()
  }

  def activate(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit = {
    stubHalt()
  }

  def deactivate(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit = {
    stubHalt()
  }

  def finalise(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit = {
    stubHalt()
  }

  def initialise(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Initialization_Api): Unit = {
    stubHalt()
  }

  def recover(api: isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Operational_Api): Unit = {
    stubHalt()
  }
}
