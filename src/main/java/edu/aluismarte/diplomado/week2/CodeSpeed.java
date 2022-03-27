package edu.aluismarte.diplomado.week2;

/**
 * @author aluis on 3/26/2022.
 */
public class CodeSpeed {

    public static void main(String[] args) {
        System.out.println("Slow: " + power(2, 8));
        System.out.println("Slow: " + power(4, 2));
        System.out.println("Fast: " + fastPower(2, 8));
        System.out.println("Fast: " + fastPower(4, 2));
    }

    private static double power(int n, int power) {
        double result = n;
        for (int i = 1; i < power; i++) {
            result *= n;
        }
        return result;
    }

    /**
     * Obtengo la potencia usando la forma rápida
     * <p>
     * Se puede pensar
     * <p>
     * 2^8
     * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 =
     * 4 * 4 * 4 * 4 =
     * 16 * 16 =
     * 256
     * <p>
     * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 =
     * 4 * 2 * 2 * 2 * 2 * 2 * 2 =
     * 8 * 2 * 2 * 2 * 2 * 2 =
     * 16 * 2 * 2 * 2 * 2 =
     * 32 * 2 * 2 * 2 =
     * 64 * 2 * 2 =
     * 128 * 2 =
     * 256
     *
     * @param n     base
     * @param power Potencia
     * @return n^power
     */
    private static double fastPower(int n, int power) {
        long result = 1;
        while (power > 0) {
            if ((power & 1) == 0) {
                n *= n;
                power >>>= 1; // Obtengo la mitad
            } else {
                result *= n;
                power--;
            }
        }
        return result;
    }
}
