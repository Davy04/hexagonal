package com.woolley.hexagonal.adapters.out;

import com.woolley.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.woolley.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.woolley.hexagonal.application.core.domain.Address;
import com.woolley.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;
    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
