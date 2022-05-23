// #Sireum

package isolette

import org.sireum._
import isolette._

@msig trait PlatformConfig {
  def setup(): Unit
}

object AppPlatform {

  def setup(config: PlatformConfig): Unit = {
    isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_EntryPoints.impl = Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_EntryPointsImpl()
    isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_EntryPoints.impl = Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_EntryPointsImpl()
    isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_EntryPoints.impl = Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_EntryPointsImpl()
    isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_EntryPoints.impl = Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_EntryPointsImpl()
    isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_EntryPoints.impl = Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_EntryPointsImpl()
    isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_EntryPoints.impl = Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_EntryPointsImpl()
    isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_EntryPoints.impl = operator_interface_thread_impl_operator_interface_oip_oit_EntryPointsImpl()
    isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_EntryPoints.impl = Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_EntryPointsImpl()
    isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_EntryPoints.impl = Heat_Source_impl_heat_source_cpi_heat_controller_EntryPointsImpl()

    config.setup()
  }

  @record class Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_EntryPointsImpl extends isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_EntryPointsSig {
    def timeTriggered(api: isolette.Regulate.Manage_Regulator_Interface_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.timeTriggered(api)
    }

    def activate(api: isolette.Regulate.Manage_Regulator_Interface_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.activate(api)
    }

    def deactivate(api: isolette.Regulate.Manage_Regulator_Interface_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.deactivate(api)
    }

    def finalise(api: isolette.Regulate.Manage_Regulator_Interface_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.finalise(api)
    }

    def initialise(api: isolette.Regulate.Manage_Regulator_Interface_impl_Initialization_Api): Unit = {
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.initialise(api)
    }

    def recover(api: isolette.Regulate.Manage_Regulator_Interface_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.recover(api)
    }
  }


  @record class Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_EntryPointsImpl extends isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_EntryPointsSig {
    def timeTriggered(api: isolette.Regulate.Manage_Heat_Source_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.timeTriggered(api)
    }

    def activate(api: isolette.Regulate.Manage_Heat_Source_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.activate(api)
    }

    def deactivate(api: isolette.Regulate.Manage_Heat_Source_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.deactivate(api)
    }

    def finalise(api: isolette.Regulate.Manage_Heat_Source_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.finalise(api)
    }

    def initialise(api: isolette.Regulate.Manage_Heat_Source_impl_Initialization_Api): Unit = {
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.initialise(api)
    }

    def recover(api: isolette.Regulate.Manage_Heat_Source_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.recover(api)
    }
  }


  @record class Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_EntryPointsImpl extends isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_EntryPointsSig {
    def timeTriggered(api: isolette.Regulate.Manage_Regulator_Mode_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.timeTriggered(api)
    }

    def activate(api: isolette.Regulate.Manage_Regulator_Mode_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.activate(api)
    }

    def deactivate(api: isolette.Regulate.Manage_Regulator_Mode_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.deactivate(api)
    }

    def finalise(api: isolette.Regulate.Manage_Regulator_Mode_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.finalise(api)
    }

    def initialise(api: isolette.Regulate.Manage_Regulator_Mode_impl_Initialization_Api): Unit = {
      isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.initialise(api)
    }

    def recover(api: isolette.Regulate.Manage_Regulator_Mode_impl_Operational_Api): Unit = {
      isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.recover(api)
    }
  }


  @record class Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_EntryPointsImpl extends isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_EntryPointsSig {
    def timeTriggered(api: isolette.Monitor.Manage_Alarm_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.timeTriggered(api)
    }

    def activate(api: isolette.Monitor.Manage_Alarm_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.activate(api)
    }

    def deactivate(api: isolette.Monitor.Manage_Alarm_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.deactivate(api)
    }

    def finalise(api: isolette.Monitor.Manage_Alarm_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.finalise(api)
    }

    def initialise(api: isolette.Monitor.Manage_Alarm_impl_Initialization_Api): Unit = {
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.initialise(api)
    }

    def recover(api: isolette.Monitor.Manage_Alarm_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.recover(api)
    }
  }


  @record class Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_EntryPointsImpl extends isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_EntryPointsSig {
    def timeTriggered(api: isolette.Monitor.Manage_Monitor_Interface_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.timeTriggered(api)
    }

    def activate(api: isolette.Monitor.Manage_Monitor_Interface_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.activate(api)
    }

    def deactivate(api: isolette.Monitor.Manage_Monitor_Interface_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.deactivate(api)
    }

    def finalise(api: isolette.Monitor.Manage_Monitor_Interface_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.finalise(api)
    }

    def initialise(api: isolette.Monitor.Manage_Monitor_Interface_impl_Initialization_Api): Unit = {
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.initialise(api)
    }

    def recover(api: isolette.Monitor.Manage_Monitor_Interface_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.recover(api)
    }
  }


  @record class Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_EntryPointsImpl extends isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_EntryPointsSig {
    def timeTriggered(api: isolette.Monitor.Manage_Monitor_Mode_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.timeTriggered(api)
    }

    def activate(api: isolette.Monitor.Manage_Monitor_Mode_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.activate(api)
    }

    def deactivate(api: isolette.Monitor.Manage_Monitor_Mode_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.deactivate(api)
    }

    def finalise(api: isolette.Monitor.Manage_Monitor_Mode_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.finalise(api)
    }

    def initialise(api: isolette.Monitor.Manage_Monitor_Mode_impl_Initialization_Api): Unit = {
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.initialise(api)
    }

    def recover(api: isolette.Monitor.Manage_Monitor_Mode_impl_Operational_Api): Unit = {
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.recover(api)
    }
  }


  @record class operator_interface_thread_impl_operator_interface_oip_oit_EntryPointsImpl extends isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_EntryPointsSig {
    def timeTriggered(api: isolette.Isolette.operator_interface_thread_impl_Operational_Api): Unit = {
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit.timeTriggered(api)
    }

    def activate(api: isolette.Isolette.operator_interface_thread_impl_Operational_Api): Unit = {
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit.activate(api)
    }

    def deactivate(api: isolette.Isolette.operator_interface_thread_impl_Operational_Api): Unit = {
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit.deactivate(api)
    }

    def finalise(api: isolette.Isolette.operator_interface_thread_impl_Operational_Api): Unit = {
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit.finalise(api)
    }

    def initialise(api: isolette.Isolette.operator_interface_thread_impl_Initialization_Api): Unit = {
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit.initialise(api)
    }

    def recover(api: isolette.Isolette.operator_interface_thread_impl_Operational_Api): Unit = {
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit.recover(api)
    }
  }


  @record class Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_EntryPointsImpl extends isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_EntryPointsSig {
    def timeTriggered(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat.timeTriggered(api)
    }

    def activate(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat.activate(api)
    }

    def deactivate(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat.deactivate(api)
    }

    def finalise(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat.finalise(api)
    }

    def initialise(api: isolette.Devices.Temperature_Sensor_impl_Initialization_Api): Unit = {
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat.initialise(api)
    }

    def recover(api: isolette.Devices.Temperature_Sensor_impl_Operational_Api): Unit = {
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat.recover(api)
    }
  }


  @record class Heat_Source_impl_heat_source_cpi_heat_controller_EntryPointsImpl extends isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_EntryPointsSig {
    def timeTriggered(api: isolette.Devices.Heat_Source_impl_Operational_Api): Unit = {
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller.timeTriggered(api)
    }

    def activate(api: isolette.Devices.Heat_Source_impl_Operational_Api): Unit = {
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller.activate(api)
    }

    def deactivate(api: isolette.Devices.Heat_Source_impl_Operational_Api): Unit = {
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller.deactivate(api)
    }

    def finalise(api: isolette.Devices.Heat_Source_impl_Operational_Api): Unit = {
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller.finalise(api)
    }

    def initialise(api: isolette.Devices.Heat_Source_impl_Initialization_Api): Unit = {
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller.initialise(api)
    }

    def recover(api: isolette.Devices.Heat_Source_impl_Operational_Api): Unit = {
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller.recover(api)
    }
  }

}
