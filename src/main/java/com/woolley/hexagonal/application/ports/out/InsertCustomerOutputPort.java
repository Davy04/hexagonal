package com.woolley.hexagonal.application.ports.out;

import com.woolley.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void Insert(Customer customer);
}
