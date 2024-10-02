package com.amagana.librairie_modulith.catalog.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@Builder
class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    @NotEmpty(message = "Book title is required")
    private String title;
    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Book ISBN is required")
    @NotNull(message = "Book ISBN must not be null")
    @Embedded
    private Isbn isbn;
    private LocalDate publishDate;
    private String language;
    private String description;
    @Column(unique = false, columnDefinition = "int default 1")
    private int numberOfPages;


}
