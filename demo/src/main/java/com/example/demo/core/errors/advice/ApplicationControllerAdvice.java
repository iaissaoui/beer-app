package com.example.demo.core.errors.advice;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import  org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {

    //simple global handler
    //TODO improve handling for specific Exceptions
    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus
    ResponseEntity<Object> handleAll(Exception ex, WebRequest request){


        return ResponseEntity.badRequest().body(ExceptionUtils.getStackTrace(ex));

    }

    //example for an advanced error handler leveraging ResponseEntityExceptionHandler
/*    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {

        String body = ExceptionUtils.getStackTrace(ex);

        return handleExceptionInternal(ex, body,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }*/

}
