package com.amagana.librairie_modulith.catalog;

import lombok.*;

import java.time.LocalDate;

@Builder
public record Book(String title, String isbn, LocalDate publishDate, String language, String description, int numberOfPages,
                   double price) {

}
