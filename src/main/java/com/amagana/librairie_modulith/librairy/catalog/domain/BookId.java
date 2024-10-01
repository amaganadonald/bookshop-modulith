package com.amagana.librairie_modulith.librairy.catalog.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record BookId(UUID id) {

    public BookId {
        Assert.notNull(id, "Id must be not null");
    }

    public BookId() {
        this(UUID.randomUUID());
    }
}
