package com.amagana.librairie_modulith.catalog.domain;

import com.amagana.librairie_modulith.catalog.Book;
import com.amagana.librairie_modulith.catalog.BookNotFoundException;
import com.amagana.librairie_modulith.catalog.BookService;
import com.amagana.librairie_modulith.common.PageResult;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return BookMapper.bookEntityToBook(
                bookRepository.save(BookMapper.bookToBookEntity(book))
        );
    }

    @Override
    public PageResult<Book> getBooks(int page, int size) {
        Page<Book> books = bookRepository.findAllBy(PageRequest.of(page, size));
        return new PageResult<>(books);
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(()-> new BookNotFoundException(String.format("Book with isbn :  %s not found", isbn)));
    }
}
