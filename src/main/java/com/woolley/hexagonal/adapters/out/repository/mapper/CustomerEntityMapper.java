package com.woolley.hexagonal.adapters.out.repository.mapper;

import com.woolley.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.woolley.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);
}
