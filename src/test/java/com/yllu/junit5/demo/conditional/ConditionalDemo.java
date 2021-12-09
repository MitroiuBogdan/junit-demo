package com.yllu.junit5.demo.conditional;

import com.yllu.junit5.demo.package1.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class ConditionalDemo {


    Calculator calculator=new Calculator();

    @Test
//    @DisabledOnOs({OS.WINDOWS})
//    @EnabledOnOs({OS.WINDOWS})
    @EnabledOnJre({JRE.JAVA_8,JRE.JAVA_16})
    public void assumption_test() {

        long a = 10;
        long b = 10;
//        assumeTrue(a < 0 || b < 0 ? false : true, () -> "This code is not executed because a or b is negative");

        System.out.println("Start assertion");

        long expectedSum = a + b;
        long sum = calculator.add(a, b);

        assertEquals(sum, expectedSum);
        assertNotEquals(sum, 300);
    }

    @Test
    @EnabledIfSystemProperty(named = "environment", matches = "ACC")
//    @DisabledIfEnvironmentVariable(named = "PROCESSOR_ARCHITECTURE", matches = "AMD64")
    public void conditional_test() {
        System.out.println("test_conditional - has been executed");
    }

    @Test
    @EnabledIf("customCondition") // or DisableIf()
    public void custom_conditional_test() {
        System.out.println("test custom conditional - has been executed");
    }


    public boolean customCondition() {
        return true;
    }

    @Test
    void printEnvironmentProperties() {
        System.getenv().forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @Test
    void printSystemProperties() {
        System.getProperties().forEach((k, v) -> System.out.println(k + ":" + v));
    }

    public String getStringWithDelay() throws InterruptedException {
        Thread.sleep(4000);
        return "Hello Kitty";
    }


}
