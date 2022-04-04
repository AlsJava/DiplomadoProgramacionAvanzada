package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.Operation;

import java.io.File;
import java.io.PrintWriter;

/**
 * Reescribir este código en piezas testeables
 * <p>
 * En vez de escribir directo a disco el archivo deberia recibir donde escribirlo (el file directamente)
 * El calculo no debe ser en la funcion, es una lógica separada
 *
 * @author aluis on 4/3/2022.
 */
public class Homework {

    public static void calculateAndSave(Operation operation, int a, int b) throws Exception {
        Double result = switch (operation) {
            case SUM -> (double) (a + b);
            case MULT -> (double) a * b;
            case DIV -> (double) a / b;
            default -> null;
        };
        if (result == null) {
            throw new Exception("No operation");
        }
        File file = new File("filename.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            out.println("Result is: " + result);
        }
    }

}
