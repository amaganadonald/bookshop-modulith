package com.amagana.bookshop_modulith.orders.domain.events;


import java.util.List;

public record CreateOrderRequest(List<OrderDto> orderDto, Long CustomerId) {
}
