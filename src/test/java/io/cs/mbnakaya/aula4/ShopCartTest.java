package io.cs.mbnakaya.aula4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ShopCartTest {

    @Test
    public void testCalculateShopCartTotalPrice() {
        ShopCart shopCart = new ShopCart();
        shopCart.getItems().add(new Item(1, "Produto 1", 10, true));
        shopCart.getItems().add(new Item(2, "Produto 2", 15, true));

        Assertions.assertEquals(25, shopCart.calculateTotal());
    }

    @Test
    public void testCalculateShopCartTotalEmptyList() {
        Exception result = Assertions.assertThrows(EmptyShopCartException.class, () -> new ShopCart().calculateTotal());

        Assertions.assertSame(EmptyShopCartException.class, result.getClass());
    }

    @Test
    public void testCalculateShopCartTotalWithOutOfStock() {
        ShopCart shopCart = new ShopCart();
        shopCart.getItems().add(new Item(1, "Produto 1", 10, true));
        shopCart.getItems().add(new Item(2, "Produto 2", 15, false));
        Exception result = Assertions.assertThrows(ItemOutOfStockException.class, shopCart::calculateTotal);

        Assertions.assertSame(ItemOutOfStockException.class, result.getClass());
    }
}
