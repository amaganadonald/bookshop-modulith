package com.amagana.librairie_modulith.catalog.domain;

import com.amagana.librairie_modulith.common.PageResult;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<Book> findByIsbn(String isbn);

    PageResult<Book> findAllBy(Pageable pageable);
}
