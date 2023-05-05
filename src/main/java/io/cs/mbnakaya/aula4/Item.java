package io.cs.mbnakaya.aula4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Item {
    private Integer code;
    private String description;
    private Integer value;
    private Boolean inStock;
}
