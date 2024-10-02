package com.amagana.librairie_modulith.catalog.web.controllers;

import com.amagana.librairie_modulith.catalog.domain.Book;
import com.amagana.librairie_modulith.catalog.domain.BookService;
import com.amagana.librairie_modulith.common.PageResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/books")
class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<PageResult<Book>> getAllBooks(@RequestParam(name = "page", defaultValue = "0") int page,
                                                        @RequestParam(name = "size", defaultValue = "5") int size) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.getBooks(page, size));
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.createBook(book));
    }

    @GetMapping
    public ResponseEntity<Book> findBookByIsbn(@RequestParam(name = "isbn") String isbn) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookByIsbn(isbn));
    }
}
