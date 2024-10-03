package com.amagana.bookshop_modulith.catalog.config;

import com.amagana.bookshop_modulith.catalog.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@RestControllerAdvice
class CatalogExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String TIMESTAMP = "timestamp";

    @ExceptionHandler(BookNotFoundException.class)
     ResponseEntity<ProblemDetail> handleBookNotFoundException(BookNotFoundException bookNotFoundException) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Book Not Found");
        problemDetail.setProperty(TIMESTAMP, Instant.now());
        problemDetail.setDetail(bookNotFoundException.getMessage());
        return new ResponseEntity<>(problemDetail, HttpStatus.NOT_FOUND);
    }


}
