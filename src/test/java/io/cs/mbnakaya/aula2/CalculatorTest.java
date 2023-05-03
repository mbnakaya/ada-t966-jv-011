package io.cs.mbnakaya.aula2;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class CalculatorTest {

    @Mock
    List<Integer> mockedList;

    @BeforeAll //@BeforeClass
    public static void beforeAll() {    // Executa antes da inicialização da classe
        System.out.println("BeforeAll !!!");
    }

    @BeforeEach //@Before
    public void beforeEach() {      // Executa antes de cada @Test
        System.out.println("BeforeEach");
        MockitoAnnotations.openMocks(this);
    }

    //@AfterAll
    //@AfterEach

    @Test
    public void testAreaCalc() {
        Double result = Calculator.squareArea(2.0);
        Assertions.assertEquals(4.0, result);
    }

    @Test
    public void testFibonacci() {
        Integer result = Calculator.fibonacci(0);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testMockedList() {
        Mockito.when(mockedList.size()).thenReturn(10);
        Assertions.assertEquals(10, mockedList.size());
    }

    @Test
    public void testBhaskara() {
        Exception exception = Assertions.assertThrows(
                NoPositiveSqrtFoundException.class, () -> Calculator.bhaskara(1,1,1));
        Assertions.assertSame(NoPositiveSqrtFoundException.class, exception.getClass());
    }
}
