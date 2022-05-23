// #Sireum

package isolette

import org.sireum._

object InitialValues {

  val DEFAULT_CURRENT_TEMPERATURE: F32 = 98f
  val DEFAULT_DISPLAYED_TEMPERATURE: F32 = 98f

  // ------ Regulator Subsystem -------

  val DEFAULT_LOWER_DESIRED_TEMPERATURE: F32 = 97f // [97..99]
  val LOWER_DESIRED_TEMPERATURE_LOWER_RANGE: F32 = 97f
  val LOWER_DESIRED_TEMPERATURE_UPPER_RANGE: F32 = 99f

  val DEFAULT_UPPER_DESIRED_TEMPERATURE: F32 = 99f  // [98..100]
  val UPPER_DESIRED_TEMPERATURE_LOWER_RANGE: F32 = 98f
  val UPPER_DESIRED_TEMPERATURE_UPPER_RANGE: F32 = 100f

  val DEFAULT_REGULATOR_STATUS: Isolette_Data_Model.Status.Type = Isolette_Data_Model.Status.Init_Status
  val DEFAULT_REGULATOR_INTERNAL_FAILURE_FLAG: B = false
  val DEFAULT_REGULATOR_INTERFACE_FAILURE_FLAG: B = false

  // ------ Monitor Subsystem -------

  val DEFAULT_LOWER_ALARM_TEMPERATURE: F32 = 95f   // [93..98]
  @spec def default_lower_alarm_temperature_Inv = Invariant(
    DEFAULT_LOWER_ALARM_TEMPERATURE == 95.0f
  )
  val LOWER_ALARM_TEMPERATURE_LOWER_RANGE: F32 = 93f
  @spec def lower_alarm_temperature_lower_range_Inv = Invariant(
    LOWER_ALARM_TEMPERATURE_LOWER_RANGE == 93.0f
  )
  val LOWER_ALARM_TEMPERATURE_UPPER_RANGE: F32 = 98f
  @spec def lower_alarm_temperature_upper_range_Inv = Invariant(
    UPPER_ALARM_TEMPERATURE_LOWER_RANGE == 98.0f
  )
  val DEFAULT_UPPER_ALARM_TEMPERATURE: F32 = 101f    // [99..103]
  @spec def default_upper_alarm_temperature_Inv = Invariant(
    DEFAULT_UPPER_ALARM_TEMPERATURE == 101.0f
  )
  val UPPER_ALARM_TEMPERATURE_LOWER_RANGE: F32 = 99f
  @spec def upper_alarm_temperature_lower_range_Inv = Invariant(
    UPPER_ALARM_TEMPERATURE_LOWER_RANGE == 99.0f
  )
  val UPPER_ALARM_TEMPERATURE_UPPER_RANGE: F32 = 103f
  @spec def upper_alarm_temperature_upper_range_Inv = Invariant(
    UPPER_ALARM_TEMPERATURE_UPPER_RANGE == 103.0f
  )

  val DEFAULT_MONITOR_STATUS: Isolette_Data_Model.Status.Type = Isolette_Data_Model.Status.Init_Status
  val DEFAULT_MONITOR_INTERNAL_FAILURE_FLAG: B = false
  val DEFAULT_MONITOR_INTERFACE_FAILURE_FLAG: B = false
}
