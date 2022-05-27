// #Sireum

package isolette.config

import org.sireum._
import art.DataContent
import isolette._

object TranspilerUtil {
  def touch(): Unit = {
    if(F) {
      TranspilerToucher.touch()

      // add types used in Platform.receive and Platform.receiveAsync
      val mbox2Boolean_Payload: MBox2[art.Art.PortId, DataContent] = MBox2(0, Base_Types.Boolean_Payload(T))
      val mbox2OptionDataContent: MBox2[art.Art.PortId, Option[DataContent]] = MBox2(0, None())

      // touch process/thread timing properties
      println(Schedulers.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_timingProperties)
      println(Schedulers.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_timingProperties)
      println(Schedulers.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_timingProperties)
      println(Schedulers.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_timingProperties)
      println(Schedulers.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_timingProperties)
      println(Schedulers.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_timingProperties)
      println(Schedulers.isolette_single_sensor_Instance_operator_interface_oip_oit_timingProperties)
      println(Schedulers.isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_timingProperties)
      println(Schedulers.isolette_single_sensor_Instance_heat_source_cpi_heat_controller_timingProperties)

      // touch each payload/type in case some are only used as a field in a record
      def printDataContent(a: art.DataContent): Unit = { println(s"${a}") }

      printDataContent(Isolette_Environment.Heat_Payload(Isolette_Environment.Heat.byOrdinal(0).get))
      printDataContent(Isolette_Environment.Interface_Interaction_Payload(Isolette_Environment.Interface_Interaction.byOrdinal(0).get))
      printDataContent(Base_Types.Float_32_Payload(Base_Types.Float_32_example()))
      printDataContent(Isolette_Data_Model.PhysicalTemp_impl_Payload(Isolette_Data_Model.PhysicalTemp_impl.example()))
      printDataContent(Isolette_Data_Model.ValueStatus_Payload(Isolette_Data_Model.ValueStatus.byOrdinal(0).get))
      printDataContent(Isolette_Data_Model.TempWstatus_impl_Payload(Isolette_Data_Model.TempWstatus_impl.example()))
      printDataContent(Isolette_Data_Model.On_Off_Payload(Isolette_Data_Model.On_Off.byOrdinal(0).get))
      printDataContent(Isolette_Data_Model.Status_Payload(Isolette_Data_Model.Status.byOrdinal(0).get))
      printDataContent(Isolette_Data_Model.Temp_impl_Payload(Isolette_Data_Model.Temp_impl.example()))
      printDataContent(Isolette_Data_Model.Regulator_Mode_Payload(Isolette_Data_Model.Regulator_Mode.byOrdinal(0).get))
      printDataContent(Base_Types.Boolean_Payload(Base_Types.Boolean_example()))
      printDataContent(Isolette_Data_Model.Failure_Flag_impl_Payload(Isolette_Data_Model.Failure_Flag_impl.example()))
      printDataContent(Isolette_Data_Model.Monitor_Mode_Payload(Isolette_Data_Model.Monitor_Mode.byOrdinal(0).get))
      printDataContent(art.Empty())

      {
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_initialization_api.get.logInfo("")
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_initialization_api.get.logDebug("")
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_initialization_api.get.logError("")
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_operational_api.get.logInfo("")
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_operational_api.get.logDebug("")
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_operational_api.get.logError("")
        val apiUsage_upper_desired_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_operational_api.get.get_upper_desired_tempWstatus()
        val apiUsage_lower_desired_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_operational_api.get.get_lower_desired_tempWstatus()
        val apiUsage_current_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_operational_api.get.get_current_tempWstatus()
        val apiUsage_regulator_mode: Option[Isolette_Data_Model.Regulator_Mode.Type] = isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_operational_api.get.get_regulator_mode()
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_initialization_api.get.put_upper_desired_temp(Isolette_Data_Model.Temp_impl.example())
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_operational_api.get.put_upper_desired_temp(Isolette_Data_Model.Temp_impl.example())
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_initialization_api.get.put_lower_desired_temp(Isolette_Data_Model.Temp_impl.example())
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_operational_api.get.put_lower_desired_temp(Isolette_Data_Model.Temp_impl.example())
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_initialization_api.get.put_displayed_temp(Isolette_Data_Model.Temp_impl.example())
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_operational_api.get.put_displayed_temp(Isolette_Data_Model.Temp_impl.example())
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_initialization_api.get.put_regulator_status(Isolette_Data_Model.Status.byOrdinal(0).get)
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_operational_api.get.put_regulator_status(Isolette_Data_Model.Status.byOrdinal(0).get)
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_initialization_api.get.put_interface_failure(Isolette_Data_Model.Failure_Flag_impl.example())
        isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_Bridge.c_operational_api.get.put_interface_failure(Isolette_Data_Model.Failure_Flag_impl.example())
      }
      {
        isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Bridge.c_initialization_api.get.logInfo("")
        isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Bridge.c_initialization_api.get.logDebug("")
        isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Bridge.c_initialization_api.get.logError("")
        isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Bridge.c_operational_api.get.logInfo("")
        isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Bridge.c_operational_api.get.logDebug("")
        isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Bridge.c_operational_api.get.logError("")
        val apiUsage_current_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Bridge.c_operational_api.get.get_current_tempWstatus()
        val apiUsage_lower_desired_temp: Option[Isolette_Data_Model.Temp_impl] = isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Bridge.c_operational_api.get.get_lower_desired_temp()
        val apiUsage_upper_desired_temp: Option[Isolette_Data_Model.Temp_impl] = isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Bridge.c_operational_api.get.get_upper_desired_temp()
        val apiUsage_regulator_mode: Option[Isolette_Data_Model.Regulator_Mode.Type] = isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Bridge.c_operational_api.get.get_regulator_mode()
        isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Bridge.c_initialization_api.get.put_heat_control(Isolette_Data_Model.On_Off.byOrdinal(0).get)
        isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Bridge.c_operational_api.get.put_heat_control(Isolette_Data_Model.On_Off.byOrdinal(0).get)
      }
      {
        isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Bridge.c_initialization_api.get.logInfo("")
        isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Bridge.c_initialization_api.get.logDebug("")
        isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Bridge.c_initialization_api.get.logError("")
        isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Bridge.c_operational_api.get.logInfo("")
        isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Bridge.c_operational_api.get.logDebug("")
        isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Bridge.c_operational_api.get.logError("")
        val apiUsage_current_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Bridge.c_operational_api.get.get_current_tempWstatus()
        val apiUsage_interface_failure: Option[Isolette_Data_Model.Failure_Flag_impl] = isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Bridge.c_operational_api.get.get_interface_failure()
        val apiUsage_internal_failure: Option[Isolette_Data_Model.Failure_Flag_impl] = isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Bridge.c_operational_api.get.get_internal_failure()
        isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Bridge.c_initialization_api.get.put_regulator_mode(Isolette_Data_Model.Regulator_Mode.byOrdinal(0).get)
        isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Bridge.c_operational_api.get.put_regulator_mode(Isolette_Data_Model.Regulator_Mode.byOrdinal(0).get)
      }
      {
        isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Bridge.c_initialization_api.get.logInfo("")
        isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Bridge.c_initialization_api.get.logDebug("")
        isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Bridge.c_initialization_api.get.logError("")
        isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Bridge.c_operational_api.get.logInfo("")
        isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Bridge.c_operational_api.get.logDebug("")
        isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Bridge.c_operational_api.get.logError("")
        val apiUsage_current_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Bridge.c_operational_api.get.get_current_tempWstatus()
        val apiUsage_lower_alarm_temp: Option[Isolette_Data_Model.Temp_impl] = isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Bridge.c_operational_api.get.get_lower_alarm_temp()
        val apiUsage_upper_alarm_temp: Option[Isolette_Data_Model.Temp_impl] = isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Bridge.c_operational_api.get.get_upper_alarm_temp()
        val apiUsage_monitor_mode: Option[Isolette_Data_Model.Monitor_Mode.Type] = isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Bridge.c_operational_api.get.get_monitor_mode()
        isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Bridge.c_initialization_api.get.put_alarm_control(Isolette_Data_Model.On_Off.byOrdinal(0).get)
        isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_Bridge.c_operational_api.get.put_alarm_control(Isolette_Data_Model.On_Off.byOrdinal(0).get)
      }
      {
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_initialization_api.get.logInfo("")
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_initialization_api.get.logDebug("")
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_initialization_api.get.logError("")
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_operational_api.get.logInfo("")
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_operational_api.get.logDebug("")
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_operational_api.get.logError("")
        val apiUsage_upper_alarm_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_operational_api.get.get_upper_alarm_tempWstatus()
        val apiUsage_lower_alarm_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_operational_api.get.get_lower_alarm_tempWstatus()
        val apiUsage_current_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_operational_api.get.get_current_tempWstatus()
        val apiUsage_monitor_mode: Option[Isolette_Data_Model.Monitor_Mode.Type] = isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_operational_api.get.get_monitor_mode()
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_initialization_api.get.put_upper_alarm_temp(Isolette_Data_Model.Temp_impl.example())
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_operational_api.get.put_upper_alarm_temp(Isolette_Data_Model.Temp_impl.example())
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_initialization_api.get.put_lower_alarm_temp(Isolette_Data_Model.Temp_impl.example())
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_operational_api.get.put_lower_alarm_temp(Isolette_Data_Model.Temp_impl.example())
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_initialization_api.get.put_monitor_status(Isolette_Data_Model.Status.byOrdinal(0).get)
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_operational_api.get.put_monitor_status(Isolette_Data_Model.Status.byOrdinal(0).get)
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_initialization_api.get.put_interface_failure(Isolette_Data_Model.Failure_Flag_impl.example())
        isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Bridge.c_operational_api.get.put_interface_failure(Isolette_Data_Model.Failure_Flag_impl.example())
      }
      {
        isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Bridge.c_initialization_api.get.logInfo("")
        isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Bridge.c_initialization_api.get.logDebug("")
        isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Bridge.c_initialization_api.get.logError("")
        isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Bridge.c_operational_api.get.logInfo("")
        isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Bridge.c_operational_api.get.logDebug("")
        isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Bridge.c_operational_api.get.logError("")
        val apiUsage_current_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Bridge.c_operational_api.get.get_current_tempWstatus()
        val apiUsage_interface_failure: Option[Isolette_Data_Model.Failure_Flag_impl] = isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Bridge.c_operational_api.get.get_interface_failure()
        val apiUsage_internal_failure: Option[Isolette_Data_Model.Failure_Flag_impl] = isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Bridge.c_operational_api.get.get_internal_failure()
        isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Bridge.c_initialization_api.get.put_monitor_mode(Isolette_Data_Model.Monitor_Mode.byOrdinal(0).get)
        isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Bridge.c_operational_api.get.put_monitor_mode(Isolette_Data_Model.Monitor_Mode.byOrdinal(0).get)
      }
      {
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.logInfo("")
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.logDebug("")
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.logError("")
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.logInfo("")
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.logDebug("")
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.logError("")
        val apiUsage_regulator_status: Option[Isolette_Data_Model.Status.Type] = isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.get_regulator_status()
        val apiUsage_monitor_status: Option[Isolette_Data_Model.Status.Type] = isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.get_monitor_status()
        val apiUsage_display_temperature: Option[Isolette_Data_Model.Temp_impl] = isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.get_display_temperature()
        val apiUsage_alarm_control: Option[Isolette_Data_Model.On_Off.Type] = isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.get_alarm_control()
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.put_lower_desired_tempWstatus(Isolette_Data_Model.TempWstatus_impl.example())
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.put_lower_desired_tempWstatus(Isolette_Data_Model.TempWstatus_impl.example())
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.put_upper_desired_tempWstatus(Isolette_Data_Model.TempWstatus_impl.example())
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.put_upper_desired_tempWstatus(Isolette_Data_Model.TempWstatus_impl.example())
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.put_lower_alarm_tempWstatus(Isolette_Data_Model.TempWstatus_impl.example())
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.put_lower_alarm_tempWstatus(Isolette_Data_Model.TempWstatus_impl.example())
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.put_upper_alarm_tempWstatus(Isolette_Data_Model.TempWstatus_impl.example())
        isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.put_upper_alarm_tempWstatus(Isolette_Data_Model.TempWstatus_impl.example())
      }
      {
        isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api.get.logInfo("")
        isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api.get.logDebug("")
        isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api.get.logError("")
        isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.logInfo("")
        isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.logDebug("")
        isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.logError("")
        val apiUsage_air: Option[Isolette_Data_Model.PhysicalTemp_impl] = isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.get_air()
        isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api.get.put_current_tempWstatus(Isolette_Data_Model.TempWstatus_impl.example())
        isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.put_current_tempWstatus(Isolette_Data_Model.TempWstatus_impl.example())
      }
      {
        isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api.get.logInfo("")
        isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api.get.logDebug("")
        isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api.get.logError("")
        isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.logInfo("")
        isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.logDebug("")
        isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.logError("")
        val apiUsage_heat_control: Option[Isolette_Data_Model.On_Off.Type] = isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.get_heat_control()
        isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api.get.put_heat_out(Isolette_Environment.Heat.byOrdinal(0).get)
        isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.put_heat_out(Isolette_Environment.Heat.byOrdinal(0).get)
      }
    }
  }
}
