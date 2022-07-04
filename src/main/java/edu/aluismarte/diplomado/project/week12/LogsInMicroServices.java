package edu.aluismarte.diplomado.project.week12;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Conoceremos la técnica apropiada para hacer debug de los procesos en un micro servicio
 * <p>
 * Una parte importante de un proyecto es poder entender que pasó paso a paso
 * Como establecer el seguimiento de un request, ya que cada request es asincrónico
 *
 * @author aluis on 6/19/2022.
 */
@Slf4j
public class LogsInMicroServices {

    private static final Map<Integer, Long> FACTORIALS = new HashMap<>() {{
        put(0, 1L);
        put(1, 1L);
        put(2, 2L);
        put(3, 6L);
    }};

    /**
     * Los procesos complejos deben tener debug informativo en caso de correr en modo debug y hacer un info indicando que termino el proceso
     *
     * @param id  El ID siempre debe existir, pues como es una estructura de MS no sabes que nodo ejecutará y es vital para dar track
     * @param num El numero a sacar el factorial
     * @return Factorial del número
     */
    public long factorial(String id, int num) {
        log.info("Running process ID: {}", id);
        if (FACTORIALS.get(num) == null) {
            log.info("Starting factorial calculation process, value {} is not in memory", num);
            int size = FACTORIALS.size();
            for (int i = size; i <= num; i++) {
                Long lastValueCalculated = FACTORIALS.get(i - 1);
                long factorial = lastValueCalculated * i;
                log.debug("Factorial ({}) pre calculated is {}", i, factorial);
                FACTORIALS.put(i, factorial);
            }
            log.info("Ending factorial calculation process, value {}", num);
        }
        return FACTORIALS.get(num);
    }

    public static void main(String[] args) {
        LogsInMicroServices logsInMicroServices = new LogsInMicroServices();
        int num = 8;
        long factorial = logsInMicroServices.factorial(UUID.randomUUID().toString(), num);
        System.out.println("Factorial of " + num + " is " + factorial);
        System.out.println("-------------------");
        logsInMicroServices.factorial(UUID.randomUUID().toString(), 5);
        System.out.println("-------------------");
        logsInMicroServices.factorial(UUID.randomUUID().toString(), 10);
    }

}
