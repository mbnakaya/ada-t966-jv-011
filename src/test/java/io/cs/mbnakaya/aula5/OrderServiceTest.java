package io.cs.mbnakaya.aula5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @Test
    public void testShippingCostToSP() {
        Order result = new OrderService().create(15,2,"BA");
        Assertions.assertEquals(45, result.getTotal());
    }

    @Test
    public void testShippingCostToOutOfSP() {
        Order result = new OrderService().create(15,2,"SP");
        Assertions.assertEquals(30, result.getTotal());
    }

    @Test
    public void testShippingCostToExpensiveOrder() {
        Order result = new OrderService().create(60,2,"AM");
        Assertions.assertEquals(120, result.getTotal());
    }

    @Test
    public void testShippingCostToExpensiveOrderMoreThan500() {
        Order result = new OrderService().create(101,5,"SP");
        Assertions.assertEquals((505 * 0.85), result.getTotal());
    }
}
