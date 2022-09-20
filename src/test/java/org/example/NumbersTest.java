package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumbersTest {

    Numbers num = new Numbers();

    @Test
    @DisplayName("Assert sum of integer numbers")
    void sumIntNumbers() {
        Assertions.assertEquals(8, num.addTwoIntNumbers(3, 5),
                () -> "Wrong sum of integer numbers");
    }

    @Test
    @DisplayName("Assert sum of float numbers")
    void sumFloatNumbers() {
        Assertions.assertEquals(4.2f, num.addTwoFloatNumbers(3.0f, 1.2f),
                () -> "Wrong sum of float numbers");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, -4, 72, 20})
    @DisplayName("Assert number is even")
    void evenNumber(int number) {
        Assertions.assertTrue(num.isEven(number), "'Assert number is even' test failed");
    }
}
