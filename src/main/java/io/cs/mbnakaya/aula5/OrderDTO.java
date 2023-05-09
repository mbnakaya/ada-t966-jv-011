package io.cs.mbnakaya.aula5;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class OrderDTO implements Serializable {

    private Integer itemPrice;
    private Integer quantity;
    private String shippingTo;
}
