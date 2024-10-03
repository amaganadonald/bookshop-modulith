package com.amagana.bookshop_modulith.catalog;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String message) {
        super(message);
    }
}
