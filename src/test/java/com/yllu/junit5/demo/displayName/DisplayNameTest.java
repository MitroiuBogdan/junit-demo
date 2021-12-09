package com.yllu.junit5.demo.displayName;

import com.yllu.junit5.demo.package1.Calculator;
import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@IndicativeSentencesGeneration(separator = "**", generator = DisplayNameGenerator.ReplaceUnderscores.class)
//@DisplayNameGeneration(DisplayNameTest.CustomDisplayNameGenerator.class)
public class DisplayNameTest {

    Calculator calculator = new Calculator();

    @Test
//    @DisplayName("Test Sum")
    void test_sum() {

        long a = 10;
        long b = 10;

        long expectedSum = a + b;
        long sum = calculator.add(a, b);

        assertEquals(sum, expectedSum);
    }

    @Test
//    @DisplayName("Test Multiply")
    @DisplayName("😱")
    void test_multiply() throws InterruptedException {

        long a = 10;
        long b = 10;

        long expectedResult = a * b;
        long result = calculator.multiply(a, b);

        assertEquals(result, expectedResult);
    }

    static class CustomDisplayNameGenerator extends DisplayNameGenerator.Standard {

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testMethod.getName();
            return Arrays.stream(name.split("_")).collect(Collectors.joining(" | "));
        }
    }
}
