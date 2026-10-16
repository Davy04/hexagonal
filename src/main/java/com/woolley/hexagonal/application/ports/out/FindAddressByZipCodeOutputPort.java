package com.woolley.hexagonal.application.ports.out;

import com.woolley.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
