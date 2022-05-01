package edu.aluismarte.diplomado.week2;

/**
 * Detectar si un número es par o impar
 *
 * @author Aluis Marte on 11/5/2021.
 * @see <a href="https://www.geeksforgeeks.org/java-program-to-check-if-a-given-integer-is-odd-or-even/">Geeksforgeeks Even number</a>
 */
public class OddOrEven {

    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    /*
    2 Bytes (Byte = 0000 0000)
    0000 0000 0000 0000
    0000 0000 0000 0000 = 0
    0000 0000 0000 0001 = 1
    0000 0000 0000 0010 = 2
    0000 0000 0000 0011 = 3
    0000 0000 0000 0100 = 4
    0000 0000 0000 0101 = 5
     */
    public boolean isEvenBitwiseAND(int num) {
        return (num & 1) == 0;
    }

    public boolean isEvenBitwiseOR(int num) {
        return (num | 1) > num;
    }
}
