package com.woolley.hexagonal.application.ports.in;

import com.woolley.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}
