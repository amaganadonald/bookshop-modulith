package com.amagana.librairie_modulith.catalog.domain;

import lombok.*;
import org.springframework.util.Assert;

import java.time.LocalDate;

@Builder
public record Book(String title,Isbn isbn, LocalDate publishDate, String language, String description, int numberOfPage) {

}
