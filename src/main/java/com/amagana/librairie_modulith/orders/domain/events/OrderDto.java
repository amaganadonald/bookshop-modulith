package com.amagana.librairie_modulith.orders.domain.events;

public record OrderDto(String bookId, int quantity, double price) {
}
