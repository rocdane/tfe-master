package com.loga.authenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SessionErrorException extends RuntimeException{

    public SessionErrorException(String message) {
        super(message);
    }
}
