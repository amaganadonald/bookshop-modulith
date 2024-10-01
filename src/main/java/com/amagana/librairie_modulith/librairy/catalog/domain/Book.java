package com.amagana.librairie_modulith.librairy.catalog.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

@Getter
@Setter
public class Book {

    private BookId id;
    private String title;
    private Isbn isbn;

    public Book(String title, Isbn isbn) {
        Assert.notNull(title, "Title must be not null");
        Assert.notNull(isbn, "Isbn must be not null");
        this.id = new BookId();
        this.title = title;
        this.isbn = isbn;
    }


}
