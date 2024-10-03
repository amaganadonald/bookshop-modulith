package com.amagana.librairie_modulith.orders.domain.events;

import com.amagana.librairie_modulith.customers.CustomerDtoResponse;
import com.amagana.librairie_modulith.orders.domain.models.OrderItem;

import java.util.List;
import java.util.UUID;

public record CreateOrderResponse(UUID orderNumber, CustomerDtoResponse customerDtoResponse, List<OrderItem> orderItems) {
}
