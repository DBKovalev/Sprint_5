package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionParametrizedTest {

    @Mock
    Feline felineMock;

    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void doesHaveMane_returnsHavingManeBasedOnGender(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedHasMane, lion.doesHaveMane(),"Для пола" + sex + "наличие гривы должно быть" + expectedHasMane);
    }
}
