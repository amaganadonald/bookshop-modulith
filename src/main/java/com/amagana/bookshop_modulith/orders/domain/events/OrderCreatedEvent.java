package com.amagana.bookshop_modulith.orders.domain.events;

import com.amagana.bookshop_modulith.orders.domain.models.OrderItem;

import java.util.List;
import java.util.UUID;

public record OrderCreatedEvent(UUID orderNumber, List<OrderItem> orderItems) {
}
