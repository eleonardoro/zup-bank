package com.zup.zupbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ExceptionsAdvice {

    @ResponseBody
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String clientNotFoundHandler(ClientNotFoundException ex) {
      return ex.getMessage();
    }
    
    @ResponseBody
    @ExceptionHandler(ClientEmailDuplicateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String clientEmailDuplicatedHandler(ClientEmailDuplicateException ex) {
      return ex.getMessage();
    }
    
    @ResponseBody
    @ExceptionHandler(ClientCpfDuplicateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String clientCpfDuplicatedHandler(ClientCpfDuplicateException ex) {
      return ex.getMessage();
    }
}