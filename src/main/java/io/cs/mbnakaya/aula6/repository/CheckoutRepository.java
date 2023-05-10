package io.cs.mbnakaya.aula6.repository;

import io.cs.mbnakaya.aula6.model.Checkout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends CrudRepository<Checkout, Long> { }
