package io.cs.mbnakaya.aula4;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ShopCart {

    private final List<Item> items = new ArrayList<>(0);

    public Integer calculateTotal() {
        if (items.isEmpty()) throw new EmptyShopCartException();
        return items.stream().mapToInt(Item::getValue).reduce(0, Integer::sum);
    }
}
