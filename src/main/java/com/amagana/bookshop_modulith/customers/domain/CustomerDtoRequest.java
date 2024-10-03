package com.amagana.bookshop_modulith.customers.domain;

import lombok.Builder;

@Builder
public record CustomerDtoRequest(String name, String email, String password, String phone) {
}
