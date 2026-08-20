package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParametrizedTest {

    public static Object[][] getTestData() {
        return new Object[][] {
                {1, 1},
                {0, 0},
                {-1, -1},
                {10, 10}
        };
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void getKittens_withIntParameter_returnsGivenCount(int input, int expectedKittensCount){
        Feline feline = new Feline();
        assertEquals(expectedKittensCount, feline.getKittens(input),"Не совпадают ожидаемое и фактическое количества котят");
    }
}
