package com.loga.monitoringservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EtlFailedException extends RuntimeException{

    public EtlFailedException(String message) {
        super(message);
    }
}
