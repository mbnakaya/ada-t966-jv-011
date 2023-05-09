package io.cs.mbnakaya.aula5;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderDTO dto) {
        Order createdOrder = service.create(dto.getItemPrice(), dto.getQuantity(), dto.getShippingTo());
        return new ResponseEntity(createdOrder, HttpStatus.CREATED);
    }
}
