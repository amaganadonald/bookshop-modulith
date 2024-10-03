package com.amagana.bookshop_modulith.orders.domain.events;

import com.amagana.bookshop_modulith.orders.domain.models.OrderItem;

import java.util.List;
import java.util.UUID;

public record OrderSummary(Long id, UUID orderNumber, Long customerId, List<OrderItem> orderItem) {
}
