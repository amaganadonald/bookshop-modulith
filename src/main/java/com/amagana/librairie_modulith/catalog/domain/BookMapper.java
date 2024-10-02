package com.amagana.librairie_modulith.catalog.domain;


import lombok.experimental.UtilityClass;

@UtilityClass
class BookMapper {

    public Book bookEntityToBook(BookEntity bookEntity) {
        return Book.builder()
                .description(bookEntity.getDescription())
                .isbn(bookEntity.getIsbn())
                .language(bookEntity.getLanguage())
                .numberOfPage(bookEntity.getNumberOfPages())
                .publishDate(bookEntity.getPublishDate())
                .title(bookEntity.getTitle())
                .build();
    }

    public BookEntity bookToBookEntity(Book book) {
        return BookEntity.builder()
                .publishDate(book.publishDate())
                .numberOfPages(book.numberOfPage())
                .title(book.title())
                .language(book.language())
                .isbn(book.isbn())
                .description(book.description())
                .build();
    }
}
