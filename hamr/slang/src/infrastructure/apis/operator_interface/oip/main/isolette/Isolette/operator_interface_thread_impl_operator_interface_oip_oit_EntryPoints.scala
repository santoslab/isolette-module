// #Sireum

package isolette.Isolette

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

object operator_interface_thread_impl_operator_interface_oip_oit_EntryPoints {
  var impl: operator_interface_thread_impl_operator_interface_oip_oit_EntryPointsSig = operator_interface_thread_impl_operator_interface_oip_oit_EntryPointsStub()

  def timeTriggered(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit = {
    impl.timeTriggered(api)
  }

  def activate(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit = {
    impl.activate(api)
  }

  def deactivate(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit = {
    impl.deactivate(api)
  }

  def finalise(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit = {
    impl.finalise(api)
  }

  def initialise(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Initialization_Api): Unit = {
    impl.initialise(api)
  }

  def recover(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit = {
    impl.recover(api)
  }
}

@msig trait operator_interface_thread_impl_operator_interface_oip_oit_EntryPointsSig {
  def timeTriggered(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit

  def activate(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit

  def deactivate(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit

  def finalise(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit

  def initialise(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Initialization_Api): Unit

  def recover(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit
}

@record class operator_interface_thread_impl_operator_interface_oip_oit_EntryPointsStub extends operator_interface_thread_impl_operator_interface_oip_oit_EntryPointsSig {
  def stubHalt(): Unit = { halt("Stub implementation of operator_interface_thread_impl_operator_interface_oip_oit_EntryPointsSig") }

  def timeTriggered(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit = {
    stubHalt()
  }

  def activate(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit = {
    stubHalt()
  }

  def deactivate(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit = {
    stubHalt()
  }

  def finalise(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit = {
    stubHalt()
  }

  def initialise(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Initialization_Api): Unit = {
    stubHalt()
  }

  def recover(api: isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Operational_Api): Unit = {
    stubHalt()
  }
}
