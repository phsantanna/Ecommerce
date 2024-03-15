package com.project.ecommerce.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiResourceAdviceJaCadastrado {

    @ExceptionHandler(ClienteJaCadastradoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleClienteJaCadastradoException(ClienteJaCadastradoException msg){
        return new ApiError(msg.getMessage());
    }
}
