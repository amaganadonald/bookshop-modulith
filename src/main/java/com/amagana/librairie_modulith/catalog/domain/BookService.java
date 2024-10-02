package com.amagana.librairie_modulith.catalog.domain;

import com.amagana.librairie_modulith.common.PageResult;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BookService {

    Book createBook(Book book);
    PageResult<Book> getBooks(int page, int size);
    Book getBookByIsbn(String isbn);
}
