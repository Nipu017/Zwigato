package com.example.zwigato.exception;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(String message)
    {
        super(message);
    }
}
