package com.woolley.hexagonal.application.ports.in;

import com.woolley.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
