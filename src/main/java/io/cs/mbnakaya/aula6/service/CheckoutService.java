package io.cs.mbnakaya.aula6.service;

import io.cs.mbnakaya.aula6.repository.CheckoutRepository;
import io.cs.mbnakaya.aula6.model.PaymentMethod;
import io.cs.mbnakaya.aula6.model.Checkout;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private CheckoutRepository repository;

    public CheckoutService(CheckoutRepository repository) {
        this.repository = repository;
    }

    public Checkout create(Checkout checkout) {
        return repository.save(checkout);
    }

    public Checkout getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Checkout updatePaymentMethod(Long id, PaymentMethod paymentMethod) {
        Checkout checkout = repository.findById(id).orElseThrow();
        checkout.setMethod(paymentMethod);

        return checkout;
    }

    public void delete(Long id) {
        Checkout checkout = repository.findById(id).orElseThrow();
        repository.delete(checkout);
    }
}
