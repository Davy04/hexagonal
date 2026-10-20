package com.woolley.hexagonal.config;

import com.woolley.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.woolley.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.woolley.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {
    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter

    ){
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase,deleteCustomerByIdAdapter);
    }
}
