package com.amagana.librairie_modulith.orders.domain.models;

public class InvalidOrderException extends RuntimeException{

    public InvalidOrderException(String message) {
        super(message);
    }
}
