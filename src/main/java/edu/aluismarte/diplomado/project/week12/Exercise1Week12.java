package edu.aluismarte.diplomado.project.week12;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Hacer una implementación del sistema de LOG correctamente
 * <p>
 * Hacer que casa proceso haga el log adecuado según la necesidad
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
