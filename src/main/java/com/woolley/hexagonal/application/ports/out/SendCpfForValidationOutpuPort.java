package com.woolley.hexagonal.application.ports.out;

public interface SendCpfForValidationOutpuPort {
    void send(String cpf);
}
