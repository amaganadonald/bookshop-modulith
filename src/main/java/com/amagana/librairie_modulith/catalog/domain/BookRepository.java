package com.amagana.librairie_modulith.catalog.domain;

import com.amagana.librairie_modulith.catalog.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<Book> findByIsbn(String isbn);

    //@Query("SELECT b FROM BookEntity b")
    Page<Book> findAllBy(Pageable pageable);
}
