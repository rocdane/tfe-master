package com.loga.reportservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ReportingErrorException extends Exception{

    public ReportingErrorException(Exception message) {
        super(message);
    }
}
