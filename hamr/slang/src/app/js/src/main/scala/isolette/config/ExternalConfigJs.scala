package isolette.config

import org.sireum._
import art.scheduling.roundrobin.RoundRobinJsInterface
import art.scheduling.roundrobin.RoundRobinExtensions_Ext

object ExternalConfigJs {
  def setup(): Unit = {
    RoundRobinExtensions_Ext.roundRobinInterface = new RoundRobinJsInterface()

    isolette.Isolette.UserInterface.Interface_Ext.interfaceI = new isolette.Isolette.UserInterface.InterfaceJS()
  }
}
