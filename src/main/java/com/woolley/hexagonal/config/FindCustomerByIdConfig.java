package com.woolley.hexagonal.config;

import com.woolley.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.woolley.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.woolley.hexagonal.adapters.out.InsertCustomerAdapter;
import com.woolley.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.woolley.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
