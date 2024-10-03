package com.amagana.bookshop_modulith.catalog;

import com.amagana.bookshop_modulith.common.PageResult;

public interface BookService {

    Book createBook(Book book);
    PageResult<Book> getBooks(int page, int size);
    Book getBookByIsbn(String isbn);
}
