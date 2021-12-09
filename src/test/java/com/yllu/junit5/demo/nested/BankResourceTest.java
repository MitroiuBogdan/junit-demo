package com.yllu.junit5.demo.nested;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BankResourceTest {


    @Nested
    @DisplayName("GET methods")
    class GET {
        @Test
        void test_getBankInfo() {
        }

        @Test
        void test_getBanks() {
        }

    }

    @Nested
    @DisplayName("POST methods")
    class POST {

        @Test
        void test_createBank() {
        }

        @Test
        void test_updateBank() {
        }
    }

    @Nested
    @DisplayName("DELETE methods")
    class DELETE {

        @Test
        void test_deleteById() {
        }

        @Test
        void test_deleteAll() {
        }

    }

}
