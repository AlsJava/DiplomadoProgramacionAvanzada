package edu.aluismarte.diplomado.week2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Aluis on 10/25/2021.
 */
@SuppressWarnings({"ConstantConditions", "WrapperTypeMayBePrimitive", "NumberEquality", "SimplifiableAssertion"})
public class DataTypeJavaTest {

    @Test
    void intEqualsTest() {
        int a = 2;
        int b = 2;
        assertTrue(a == b, "No equals, what?!");
    }

    @Test
    void intEqualsTest2() {
        int a = 128;
        int b = 128;
        assertTrue(a == b, "No equals, what?!");
    }

    @Test
    void intEqualsTest3() {
        int a = 128000;
        int b = 128000;
        assertTrue(a == b, "No equals, what?!");
    }

    @Test
    void integerEqualTest() {
        Integer a = 127;
        Integer b = 127;
        assertTrue(a == b, "No equals, what?!");
    }

    @Test
    void integerEqualTest2() {
        Integer a = 2;
        Integer b = 2;
        assertTrue(a == b, "No equals, what?!");
    }

    @Test
    void negativeIntegerEqualTest() {
        Integer a = -2;
        Integer b = -2;
        assertTrue(a == b, "No equals, what?!");
    }

    @Test
    void negativeIntegerEqualTest2() {
        Integer a = -127;
        Integer b = -127;
        assertTrue(a == b, "No equals, what?!");
    }

    @Test
    void negativeIntegerEqualTest3() {
        Integer a = -129;
        Integer b = -129;
        assertTrue(a == b, "No equals, what?!");
    }

    @Test
    void integerNotEqualTest() {
        Integer a = 128;
        Integer b = 128;
        assertTrue(a == b, "No equals, what?!");
    }

    @Test
    void compareIntegerInGoodWayTest() {
        Integer a = 128;
        Integer b = 128;
        assertTrue(a.equals(b), "No equals, what?!");
    }
}
