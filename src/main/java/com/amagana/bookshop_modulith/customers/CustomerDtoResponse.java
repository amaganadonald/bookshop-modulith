package com.amagana.bookshop_modulith.customers;

import lombok.Builder;

@Builder
public record CustomerDtoResponse(Long id, String name, String email, String password, String phone) {
}
