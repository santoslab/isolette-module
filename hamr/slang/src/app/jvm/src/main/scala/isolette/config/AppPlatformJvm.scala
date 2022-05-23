// #Sireum

package isolette.config

import org.sireum._
import isolette._

@record class AppPlatformJvm extends PlatformConfig {
  def setup(): Unit = {
    ExternalConfig.setup()
  }
}

@ext("ExternalConfigJvm") object ExternalConfig {
  def setup(): Unit = $
}
