package com.example.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;

import lombok.extern.slf4j.Slf4j;

import com.example.dto.ErrorDTO;
import com.example.exception.CommunicationException;

@Slf4j
@ControllerAdvice("com.example")
public class ExceptionControllerAdvice {
    private static final String DEFAULT_USER_ERROR_MESSAGE = "Error. It has been logged. Please contact the system administrator.";
    private static final String ERROR_TYPE = "error";

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO handleCommunicationException(CommunicationException exception) {
        log.error(exception.getMessage(), exception);

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setType(ERROR_TYPE);
        errorDTO.setMessage(exception.getMessage());

        return errorDTO;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDTO handleOtherExceptions(Throwable throwable) {
        log.error("Error. ", throwable);

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setType(ERROR_TYPE);
        errorDTO.setMessage(DEFAULT_USER_ERROR_MESSAGE);

        return errorDTO;
    }
}
