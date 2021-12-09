package com.yllu.junit5.demo.parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParameterizedTestDemo {

    @RepeatedTest(10)
    void repeatedTest() {
        System.out.println("Test is executed");
    }

    @RepeatedTest(5)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition());
        assertEquals(5, repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 6, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void customDisplayName(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        assertEquals("Repeat! " + repetitionInfo.getCurrentRepetition() + "/6", testInfo.getDisplayName());
    }

    //--------------------------------//

    @ParameterizedTest
        @ValueSource(strings = {"race", "taxi", "1234"})
        void parameterized_test_1(String candidate) {
            assertEquals(4, candidate.toCharArray().length);
    }

    @ParameterizedTest
    @EnumSource(TimeStatus.class)
    void parameterized_test_2(TimeStatus timeStatus) {
        System.out.println(timeStatus);
    }

    //--------------------------------//
    @ParameterizedTest
    @MethodSource
    void testWithDefaultLocalMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> testWithDefaultLocalMethodSource() {
        return Stream.of("apple", "banana");
    }


    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        assertEquals(5, str.length());
        assertTrue(num >= 1 && num <= 2);
        assertEquals(2, list.size());
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("apple", 1, List.of("a", "b")),
                arguments("lemon", 2, List.of("x", "y"))
        );
    }

    //--------------------------------//
    @ParameterizedTest
    @CsvSource({
            "apple,         1",
            "banana,        2",
            "'lemon, lime', 3",
            "strawberry,    3"
    })
    void testWithCsvSource(String fruit, int rank) {  //ArgumentsAccessor arguments
        assertNotNull(fruit);
        assertNotEquals(0, rank);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/csv/countries.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String country, int reference) {
        assertNotNull(country);
        assertNotEquals(0, reference);
    }

}
