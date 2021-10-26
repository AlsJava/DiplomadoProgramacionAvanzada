package edu.aluismarte.diplomado.code.alg;

import edu.aluismarte.diplomado.utils.TimeExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Aluis on 10/25/2021.
 */
@ExtendWith(TimeExtension.class)
class PrimeNumberTest {

    private final PrimeNumber primeNumber = new PrimeNumber();
    private final List<Integer> primes = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
    private final List<Integer> noPrimes = List.of(4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22);

    @Test
    void onlyPrimesSimpleTest() {
        primes.forEach(number -> {
            System.out.println(number);
            assertTrue(primeNumber.simplePrimeNumber(number));
        });
    }

    @Test
    void onlyPrimesSimple2Test() {
        primes.forEach(number -> {
            System.out.println(number);
            assertTrue(primeNumber.simplePrimeNumber2(number));
        });
    }

    @Test
    void onlyPrimesCribaTest() {
        primes.forEach(number -> {
            System.out.println(number);
            assertTrue(primeNumber.criba(number));
        });
    }

    @Test
    void noPrimeSimpleTest() {
        noPrimes.forEach(number -> {
            System.out.println(number);
            assertFalse(primeNumber.simplePrimeNumber(number));
        });
    }

    @Test
    void noPrimeSimple2Test() {
        noPrimes.forEach(number -> {
            System.out.println(number);
            assertFalse(primeNumber.simplePrimeNumber2(number));
        });
    }

    @Test
    void noPrimeCribaTest() {
        noPrimes.forEach(number -> {
            System.out.println(number);
            assertFalse(primeNumber.criba(number));
        });
    }
}