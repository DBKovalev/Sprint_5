package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    private Cat cat;

    @BeforeEach
    void setUp(){
        cat = new Cat(felineMock);
    }

    @Test
    void getSound_returnsMeow() {
        assertEquals("Мяу", cat.getSound(), "Не совпадают ожидаемый и фактический издаваемые звуки");
    }

    @Test
    void getFood_returnsListOfFood() throws Exception {
        List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedListOfFood);
        List<String> actualListOfFood = cat.getFood();
        assertEquals(expectedListOfFood, actualListOfFood, "Не совпадают ожидаемый и фактический списки еды");
    }

    @Test
    void getFood_returnsTimesCount() throws Exception {
        cat.getFood();
        Mockito.verify(felineMock, Mockito.times(1)).eatMeat();
    }

}
