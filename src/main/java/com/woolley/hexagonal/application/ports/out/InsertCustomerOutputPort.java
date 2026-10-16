package com.woolley.hexagonal.application.ports.out;

import com.woolley.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface InsertCustomerOutputPort {
    void Insert(Customer customer);
}
