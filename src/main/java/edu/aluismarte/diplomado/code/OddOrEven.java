package edu.aluismarte.diplomado.code;

/**
 * @author Aluis Marte on 11/5/2021.
 * @see <a href="https://www.geeksforgeeks.org/java-program-to-check-if-a-given-integer-is-odd-or-even/">Geeksforgeeks Even number</a>
 */
public class OddOrEven {

    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    public boolean isEvenBitwiseAND(int num) {
        return (num & 1) == 0;
    }

    public boolean isEvenBitwiseOR(int num) {
        return (num | 1) > num;
    }
}
