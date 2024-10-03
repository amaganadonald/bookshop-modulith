package com.amagana.librairie_modulith.orders.domain.events;

import com.amagana.librairie_modulith.orders.domain.models.OrderItem;

import java.util.List;
import java.util.UUID;

public record OrderSummary(Long id, UUID orderNumber, Long customerId, List<OrderItem> orderItem) {
}
