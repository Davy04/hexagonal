package com.woolley.hexagonal.application.core.usecase;

import com.woolley.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.woolley.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.woolley.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOutputPort deleteCustomerByIDOutputPort){
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIDOutputPort;
    }
    @Override
    public void delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
