package io.cs.mbnakaya.aula5;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public Order create(Integer itemPrice, Integer quantity, String shippingTo) {
        Double totalPrice = calculateSubTotal(itemPrice, quantity).doubleValue();

        if (shippingTo != "SP" && totalPrice <= 100)
            totalPrice += 15;

        if (totalPrice > 500)
            totalPrice *= 0.85;

        return new Order(
                1L,
                "Testes",
                quantity,
                shippingTo,
                itemPrice.longValue(),
                totalPrice
        );
    }

    private Integer calculateSubTotal(Integer itemPrice, Integer quantity) {
        return itemPrice * quantity;
    }
}
