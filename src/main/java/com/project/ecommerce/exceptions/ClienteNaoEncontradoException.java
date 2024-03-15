package com.project.ecommerce.exceptions;

public class ClienteNaoEncontradoException extends IllegalAccessError{
    public ClienteNaoEncontradoException(String msg){
        super(msg);
    }
}
