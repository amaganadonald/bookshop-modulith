package com.amagana.librairie_modulith.catalog;

import com.amagana.librairie_modulith.common.PageResult;

public interface BookService {

    Book createBook(Book book);
    PageResult<Book> getBooks(int page, int size);
    Book getBookByIsbn(String isbn);
}
