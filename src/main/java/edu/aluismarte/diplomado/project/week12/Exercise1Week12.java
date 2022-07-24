package edu.aluismarte.diplomado.project.week12;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Hacer una implementación del sistema de LOG correctamente
 * <p>
 * Hacer que casa proceso haga el log adecuado según la necesidad
 * <p>
 * ¿Qué es fibonacci?
 * En matemáticas, la sucesión de Fibonacci (a veces mal llamada serie de Fibonacci) es la sucesión infinita de números naturales.
 * 0,1,1,2,3,5,8,13,21,34,55,89,144,233,377…
 * <p>
 * Ejemplo:
 * Fibonacci(0) = 0
 * Fibonacci(1) = 1
 * Fibonacci(2) = 1
 * Fibonacci(3) = 2
 * Fibonacci(4) = 3
 * Fibonacci(5) = 5
 * Fibonacci(6) = 8
 * Fibonacci(7) = 13
 * Fibonacci(8) = 21
 * Fibonacci(9) = 34
 *
 * @author aluis on 6/4/2022.
 */
@Slf4j
public class Exercise1Week12 {

    private static final Map<Integer, Long> FIBONACCI = new HashMap<>() {{
        put(0, 0L);
        put(1, 1L);
    }};

    private long fibonacci(int n) {
        if (FIBONACCI.get(n) == null) {
            int size = FIBONACCI.size();
            for (int i = size; i <= n; i++) {
                Long n1 = FIBONACCI.get(i - 2);
                Long n2 = FIBONACCI.get(i - 1);
                FIBONACCI.put(i, n1 + n2);
            }
        }
        return FIBONACCI.get(n);
    }

    public static void main(String[] args) {
        Exercise1Week12 exercise1Week12 = new Exercise1Week12();
        int num = 10;
        System.out.println();
        for (int i = 0; i < num; i++) {
            long fibonacci = exercise1Week12.fibonacci(i);
            System.out.print(fibonacci + " ");
        }
        System.out.println();
    }
}
