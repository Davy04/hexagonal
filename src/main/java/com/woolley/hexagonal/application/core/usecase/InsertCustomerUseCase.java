package com.woolley.hexagonal.application.core.usecase;

import com.woolley.hexagonal.application.core.domain.Customer;
import com.woolley.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.woolley.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.woolley.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.woolley.hexagonal.application.ports.out.SendCpfForValidationOutpuPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutpuPort sendCpfForValidationOutpuPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort, SendCpfForValidationOutpuPort sendCpfForValidationOutpuPort)
    {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutpuPort = sendCpfForValidationOutpuPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.Insert(customer);
        sendCpfForValidationOutpuPort.send(customer.getCpf());
    }
}
