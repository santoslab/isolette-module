package isolette

import org.sireum._

object Discouraged {
  // Temperature_Sensor and Heat_Source are in different processes
  // so they should not be able to communicate via global vars.
  var Heat_Source_Native_Ext__isOn: B = T
}
