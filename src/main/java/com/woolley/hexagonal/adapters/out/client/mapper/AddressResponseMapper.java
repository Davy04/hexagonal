package com.woolley.hexagonal.adapters.out.client.mapper;
import com.woolley.hexagonal.adapters.out.client.response.AddressResponse;
import com.woolley.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
