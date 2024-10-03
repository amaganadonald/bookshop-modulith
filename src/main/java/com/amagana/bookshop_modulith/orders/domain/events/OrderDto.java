package com.amagana.bookshop_modulith.orders.domain.events;

public record OrderDto(String bookId, int quantity, double price) {
}
