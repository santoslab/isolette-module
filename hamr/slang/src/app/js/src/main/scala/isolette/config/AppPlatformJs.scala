// #Sireum

package isolette.config

import org.sireum._
import isolette._

@record class AppPlatformJs extends PlatformConfig {
  def setup(): Unit = {
    ExternalConfig.setup()
  }
}

@ext("ExternalConfigJs") object ExternalConfig {
  def setup(): Unit = $
}
