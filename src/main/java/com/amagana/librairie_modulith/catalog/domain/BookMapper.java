package com.amagana.librairie_modulith.catalog.domain;


import com.amagana.librairie_modulith.catalog.Book;
import lombok.experimental.UtilityClass;

@UtilityClass
class BookMapper {

    public Book bookEntityToBook(BookEntity bookEntity) {
        return Book.builder()
                .description(bookEntity.getDescription())
                .isbn(bookEntity.getIsbn())
                .language(bookEntity.getLanguage())
                .numberOfPages(bookEntity.getNumberOfPages())
                .publishDate(bookEntity.getPublishDate())
                .title(bookEntity.getTitle())
                .price(bookEntity.getPrice())
                .build();
    }

    public BookEntity bookToBookEntity(Book book) {
        return BookEntity.builder()
                .publishDate(book.publishDate())
                .numberOfPages(book.numberOfPages())
                .title(book.title())
                .language(book.language())
                .isbn(book.isbn())
                .description(book.description())
                .price(book.price())
                .build();
    }
}
