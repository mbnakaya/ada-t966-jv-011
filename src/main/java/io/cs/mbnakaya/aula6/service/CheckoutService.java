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
        return null;
    }

    public void delete(Long id) {}
}
