package com.project.ecommerce.exceptions;


import org.springframework.web.bind.annotation.RestControllerAdvice;

public class ClienteJaCadastradoException extends IllegalArgumentException{
    public ClienteJaCadastradoException(String msg) {
        super(msg);
    }
}
