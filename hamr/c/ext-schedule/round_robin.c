#include <all.h>
#include <signal.h>

// This file will not be overwritten so is safe to edit

// Transpiled signature of the Slang variable isolette.Schedulers.roundRobinSchedule
// in architecture/isolette/Schedulers.scala.  This weak function declaration allows
// isolette_ScheduleProviderI_getRoundRobinOrder to detect whether the Slang variable was deleted
__attribute__((weak)) IS_7E8796 isolette_Schedulers_roundRobinSchedule(STACK_FRAME_ONLY);

volatile sig_atomic_t shouldStop = 0;

/*!
 * Example C implementation of the Slang extension method isolette.ScheduleProviderI.getRoundRobinOrder()
 * defined in architecture/isolette/Schedulers.scala
 *
 * @param result an empty schedule.  Add components in the order you want them to be dispatched.
 *               IS_7E8796=ISZ[art.Bridge], i.e. an immutable sequence of art.Bridge
 */
void isolette_ScheduleProviderI_getRoundRobinOrder(STACK_FRAME IS_7E8796 result) {
  DeclNewStackFrame(caller, "round_robin.c", "", "isolette_ScheduleProviderI_getRoundRobinOrder", 0);

  if(isolette_Schedulers_roundRobinSchedule) {
    printf("Using the round robin order provided in architecture/isolette/Schedulers.scala. Edit method \n");
    printf("  isolette_ScheduleProviderI_getRoundRobinOrder located in round_robin.c\n");
    printf("to supply your own\n");

    IS_7E8796 order = isolette_Schedulers_roundRobinSchedule(SF_LAST);
    memcpy(result->value, order->value, sizeof(union art_Bridge) * order->size);
    result->size = order->size;

  } else {
    printf("Transpiled Slang variable isolette.Schedulers.roundRobinSchedule not found.  Using an example schedule from method");
    printf("  isolette_ScheduleProviderI_getRoundRobinOrder located in round_robin.c\n");

    // example schedule
    int i = 0;
    IS_7E8796_up(result, i++, (art_Bridge) isolette_Arch_isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface(SF_LAST));
    IS_7E8796_up(result, i++, (art_Bridge) isolette_Arch_isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source(SF_LAST));
    IS_7E8796_up(result, i++, (art_Bridge) isolette_Arch_isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode(SF_LAST));
    IS_7E8796_up(result, i++, (art_Bridge) isolette_Arch_isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm(SF_LAST));
    IS_7E8796_up(result, i++, (art_Bridge) isolette_Arch_isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface(SF_LAST));
    IS_7E8796_up(result, i++, (art_Bridge) isolette_Arch_isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode(SF_LAST));
    IS_7E8796_up(result, i++, (art_Bridge) isolette_Arch_isolette_single_sensor_Instance_operator_interface_oip_oit(SF_LAST));
    IS_7E8796_up(result, i++, (art_Bridge) isolette_Arch_isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat(SF_LAST));
    IS_7E8796_up(result, i++, (art_Bridge) isolette_Arch_isolette_single_sensor_Instance_heat_source_cpi_heat_controller(SF_LAST));

    result->size = i;
  }
}

/*!
 * signal handler that sets shouldStop to true when invoked
 */
void sigHandler(int signo) {
  shouldStop = 1;
}

/*!
 * Example C implementation of Slang extension method art.scheduling.roundrobin.RoundRobinExtensions.init()
 * defined in art/scheduling/roundrobin/RoundRobin.scala.  The scheduler calls this
 * during the initialization phase
 *
 * It registers a signal handler that is used to shut down the demo when it receives
 * SIGINT (CTRL+C), SIGTERM, or SIGQUIT
 */
Unit art_scheduling_roundrobin_RoundRobinExtensions_init(STACK_FRAME_ONLY){
  int sigs[] = {SIGINT, SIGTERM, SIGQUIT};
  for(int i = 0; i < sizeof(sigs) / sizeof(int); i++){
    if(signal(sigs[i], sigHandler) == SIG_ERR) {
      printf("Error occurred while setting signal handler for %i\n", sigs[i]);
      exit(-1);
    }
  }
}

Unit art_scheduling_roundrobin_RoundRobinExtensions_loop(STACK_FRAME art_scheduling_roundrobin_RoundRobin roundRobin) {
  while(shouldStop != 1) {
    art_scheduling_roundrobin_RoundRobin_hyperPeriod_(SF_LAST roundRobin);
  }
}
