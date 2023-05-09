package io.cs.mbnakaya.aula5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Order {
    private Long id;
    private String customer;
    private Integer productsCount;
    private String shippingTo;
    private Long itemPrice;
    private Double total;
}
