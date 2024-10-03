package com.amagana.bookshop_modulith.orders.domain.models;

public class InvalidOrderException extends RuntimeException{

    public InvalidOrderException(String message) {
        super(message);
    }
}
