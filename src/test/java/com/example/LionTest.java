package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LionTest{

    @Mock
    private Feline felineMock;

    @Test
    void getKittens_returnsDefaultCount() throws Exception {
        int expectedKittensCount = 1;
        Mockito.when(felineMock.getKittens()).thenReturn(expectedKittensCount);
        Lion lion = new Lion("Самец", felineMock);
        int actualKittensCount = lion.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount, "Не совпадают ожидаемое и фактическое количества котят");
    }

    @Test
    void doesHaveMane_returnsExceptionTest() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> new Lion("Что-то не то", felineMock)
        );
        assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage(), "Не совпадают ожидаемое и фактическое сообщения об ошибке");
    }

    @Test
    void getFood_returnsListOfFood() throws Exception {
        List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedListOfFood);
        Lion lion = new Lion("Самец", felineMock);
        List<String> actualListOfFood = lion.getFood();
        assertEquals(expectedListOfFood, actualListOfFood, "Не совпадают ожидаемый и фактический списки еды");
    }
}
