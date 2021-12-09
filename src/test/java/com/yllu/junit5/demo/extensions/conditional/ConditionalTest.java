package com.yllu.junit5.demo.extensions.conditional;

import org.junit.jupiter.api.Test;

public class ConditionalTest {


    @Test
    @Environment(enabledFor = {"ACC"})
    void regression_test() {
        System.out.println("Run regression test");
    }


    @Test
    @Environment(enabledFor = {"DEV", "TST"})
    void performance_test() {
        System.out.println("Run performance test");
    }
}
