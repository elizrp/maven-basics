package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringsTest {

    Strings str = new Strings();

    @ParameterizedTest
    @ValueSource(strings = {"apple", "/", "0"})
    @DisplayName("Assert string is not blank")
    void notBlankString(String input) {
        Assertions.assertTrue(str.isNotBlank(input),
                "'Assert string is not blank' test failed");
    }

    @ParameterizedTest
    @CsvSource(value = {"APPLE:apple", "apPle:apple", "Apple:apple"}, delimiter = ':')
    @DisplayName("Assert string is converted to lower case")
    void lowerCaseStringCsvStructure(String input, String expected) {
        String actual = input.toLowerCase();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-input.csv", numLinesToSkip = 1)
    @DisplayName("Assert string is converted to lower case")
    void lowerCaseStringCsvFile(String input, String expected) {
        String actual = input.toLowerCase();
        Assertions.assertEquals(expected, actual);
    }
}
