package edu.aluismarte.diplomado.week2;

/**
 * Debug code
 *
 * @author aluis on 3/26/2022.
 */
public class DebugCode {

    public static void main(String[] args) {
        myFunctionToDebug(15, "Hola mundo");
    }

    private static void myFunctionToDebug(int number, String text) {
        System.out.println("Hello World!");
        System.out.println("My number: " + number);
        number *= 10;
        System.out.println("My number, part 2: " + number);
        System.out.println("My text: " + text);
        System.out.println("Wait Debugger");
    }
}
