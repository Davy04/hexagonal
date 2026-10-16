package com.woolley.hexagonal.application.ports.out;

import com.woolley.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
     Optional<Customer> find(String id);
}
