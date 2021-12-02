package com.fstg.bookeraccountservice.infra.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fstg.bookeraccountservice.infra.core.messaging.LocalMessageReader;


@Component
public class AbstractInfraImpl implements AbstractInfra {
    @Autowired
    private LocalMessageReader localMessageReader;

    public String getMessage(String code) {
        String message= localMessageReader.getMessage(code);
        return message;
    }
}
