package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    private Feline feline;

    @BeforeEach
    void setUp(){
        feline = new Feline();
    }

    @Test
    void eatMeat_returnsExpectedFoodList() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat(), "Не совпадают ожидаемый и фактический списки еды");
    }

    @Test
    void getFamily_returnsFamily(){
        assertEquals("Кошачьи", feline.getFamily(), "Не совпадают ожидаемое и фактическое семейства");
    }


    @Test
    void getKittens_withoutParameter_returnsDefaultCount(){
        assertEquals(1, feline.getKittens(), "Не совпадают ожидаемое и фактическое количества котят");
    }

}
