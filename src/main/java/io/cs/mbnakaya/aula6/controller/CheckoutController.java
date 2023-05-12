package io.cs.mbnakaya.aula6.controller;

import io.cs.mbnakaya.aula6.model.Checkout;
import io.cs.mbnakaya.aula6.model.PaymentMethod;
import io.cs.mbnakaya.aula6.service.CheckoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

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
        try {
            Checkout result = service.getById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Checkout> update(@PathVariable Long id, @RequestParam String paymentMethod) {
        try {
            Checkout result = service.updatePaymentMethod(id, PaymentMethod.valueOf(paymentMethod.toUpperCase()));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Checkout> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
