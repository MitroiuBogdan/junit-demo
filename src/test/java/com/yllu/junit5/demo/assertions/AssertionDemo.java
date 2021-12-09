package com.yllu.junit5.demo.assertions;

import com.yllu.junit5.demo.package1.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AssertionDemo {


    Calculator calculator = new Calculator();


    @Test
    public void core_assertion_test() throws InterruptedException {
        long a = 10;
        long b = 10;

        long expectedResult = a * b;
        long result = calculator.multiply(a, b);

        long sum = calculator.add(a, b);
        long expectedSum = a + b;

        assertEquals(sum, expectedSum);
        assertNotEquals(sum, 300);

        assertNull(null);
        assertNotNull(this);

        assertSame("foo", "foo");
        assertNotSame("foo", "box");


//        assertAll(
//                () -> assertEquals(sum, expectedSum),
//                () -> assertEquals(result, expectedResult)
//        );
//
//        assertTimeout(ofMillis(300), () -> {
//            calculator.multiply(a, b);
//        });

//
//
//        assertThrows(RuntimeException.class, () -> {
//            calculator.multiply(a, b);
//        });


    }
}
