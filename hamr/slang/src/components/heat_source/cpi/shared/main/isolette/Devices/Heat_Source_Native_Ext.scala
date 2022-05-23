package isolette.Devices

import isolette._

object Heat_Source_Native_Ext {

  //var isOn: Boolean = true

  def setState(value: Isolette_Data_Model.On_Off.Type): Unit = {
    Discouraged.Heat_Source_Native_Ext__isOn = value == Isolette_Data_Model.On_Off.Onn
  }
}
