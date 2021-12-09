package com.yllu.junit5.demo.tags;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@IntegrationTest
@SpringBootTest
public class DummyIntegrationTest {


    @Tag("TST")
    @Test
    void test_executed_on_tst() {
        System.out.println("This is an integration test");
    }


    @Tag("DEV")
    @Test
    void test_executed_on_dev() {
        System.out.println("This is an integration test");
    }
}
