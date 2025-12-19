package com.example.zwigato.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message)
    {
        super(message);
    }
}
