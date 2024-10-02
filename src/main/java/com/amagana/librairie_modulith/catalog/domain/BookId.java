package com.amagana.librairie_modulith.catalog.domain;

import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

import java.util.UUID;

@Embeddable
public record BookId(UUID id) {

    public BookId {
        Assert.notNull(id, "Id must be not null");
    }

    public BookId() {
        this(UUID.randomUUID());
    }
}
