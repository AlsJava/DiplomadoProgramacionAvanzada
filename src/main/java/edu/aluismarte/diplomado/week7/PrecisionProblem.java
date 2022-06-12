package edu.aluismarte.diplomado.week7;

/**
 * Código demostrativo con el objetivo de mostrar el nivel de perfección de los calculos decimales en JAVA
 *
 * @author aluis on 5/2/2022.
 */
public class PrecisionProblem {

    public double calculareFloatRange(double lowLimit, double highLimit, double increment, double brakeFor) {
        double result = 0.0;
        for (double i = lowLimit; i < highLimit; i += increment) {
            System.out.println("Valor de i: " + i);
            if (i == brakeFor) {
                break;
            } else {
                result += increment;
            }
        }
        return result;
    }
}
