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
 * <p>
 * ¿Qué es un factorial?
 * Cantidad que resulta de la multiplicación de determinado número natural por todos los números naturales que le anteceden excluyendo el cero;
 * se representa por n!
 * <p>
 * Ejemplo:
 * 0! = 1 = 1
 * 1! = 1 = 1
 * 2! = 2 * 1 = 2
 * 3! = 3 * 2 * 1 = 6
 * 4! = 4 * 3 * 2 * 1 = 24
 * 5! = 5 * 4 * 3 * 2 * 1 = 120
 * 6! = 6 * 5 * 4 * 3 * 2 * 1 = 720
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
        log.info("Running process ID: {} and factorial {} ", id, num);
        if (FACTORIALS.get(num) == null) {
            log.info("{} - Starting factorial calculation process, value {} is not in memory", id, num);
            int size = FACTORIALS.size();
            for (int i = size; i <= num; i++) {
                Long lastValueCalculated = FACTORIALS.get(i - 1);
                long factorial = lastValueCalculated * i;
                log.debug("{} - Factorial ({}) pre calculated is {}", id, i, factorial);
                FACTORIALS.put(i, factorial);
            }
            log.info("{} - Ending factorial calculation process, value {}", id, num);
        }
        return FACTORIALS.get(num);
    }

    public static void main(String[] args) {
        LogsInMicroServices logsInMicroServices = new LogsInMicroServices();
        int num = 8;
        long factorial = logsInMicroServices.factorial(UUID.randomUUID().toString(), num);
        System.out.println("Factorial of " + num + " is " + factorial);
        System.out.println("-------------------");
        num = 5;
        factorial = logsInMicroServices.factorial(UUID.randomUUID().toString(), num);
        System.out.println("Factorial of " + num + " is " + factorial);
        System.out.println("-------------------");
        num = 10;
        factorial = logsInMicroServices.factorial(UUID.randomUUID().toString(), num);
        System.out.println("Factorial of " + num + " is " + factorial);
    }

}
