package com.woolley.hexagonal.adapters.out;

import com.woolley.hexagonal.adapters.out.repository.CustomerRepository;
import com.woolley.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
