package com.woolley.hexagonal.adapters.out;

import com.woolley.hexagonal.application.ports.out.SendCpfForValidationOutpuPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutpuPort {

    @Autowired
    private KafkaTemplate<String,String>kafkaTemplate;

    @Override
    public void send(String cpf){
        kafkaTemplate.send("tp-cpf-validation",cpf);
    }
}
