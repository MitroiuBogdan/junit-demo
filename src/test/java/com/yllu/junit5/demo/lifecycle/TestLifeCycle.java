package com.yllu.junit5.demo.lifecycle;

import org.junit.jupiter.api.*;

public class TestLifeCycle {


    @BeforeAll
    static void initAll() {
        System.out.println("initAll - initAll");
    }

    @BeforeEach
    void init() {
        System.out.println("beforeEach - init");
    }

    @Test
    void test_1() {
        System.out.println("test_1");
    }


    @Test
    void test_2() {
        System.out.println("test_2");
    }

    @AfterEach
    void clean() {
        System.out.println("afterEach - clean");
    }

    @AfterAll
    static void cleanAll() {
        System.out.println("cleanAll - cleanAll");
    }


}
