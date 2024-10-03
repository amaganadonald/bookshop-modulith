package com.amagana.bookshop_modulith.orders.domain.models;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String message) {
        super(message);
    }
}
