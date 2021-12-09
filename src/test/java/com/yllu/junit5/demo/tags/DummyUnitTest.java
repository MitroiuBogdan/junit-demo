package com.yllu.junit5.demo.tags;

import org.junit.jupiter.api.Test;

@UnitTest
public class DummyUnitTest {


    @Test
    void test_something() {
        System.out.println("This is an unit test");
    }

}
