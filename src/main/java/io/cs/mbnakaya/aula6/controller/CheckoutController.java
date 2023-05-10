package io.cs.mbnakaya.aula6.controller;

import io.cs.mbnakaya.aula6.model.Checkout;
import io.cs.mbnakaya.aula6.service.CheckoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/checkout")
public class CheckoutController {

    private CheckoutService service;

    public  CheckoutController(CheckoutService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Checkout> create(@RequestBody Checkout body) {
        Checkout result = service.create(body);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Checkout> getById(@PathVariable Long id) {
        Checkout result = service.getById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // UPDATE (

    // DELETE
}
