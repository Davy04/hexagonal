package com.woolley.hexagonal.application.ports.in;

import com.woolley.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
