package com.amagana.librairie_modulith.catalog.domain;

import jakarta.persistence.Embeddable;
import org.apache.commons.validator.routines.ISBNValidator;

@Embeddable
public record Isbn(String value) {
     private static final ISBNValidator VALIDATOR = new ISBNValidator();

    public Isbn() {
         this("");
    }

    public Isbn {
          if(!VALIDATOR.isValid(value)) {
               throw new IllegalArgumentException("Invalid isbn" + value);
          }
     }

}
