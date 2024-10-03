package com.amagana.bookshop_modulith.orders.domain.models;

import com.amagana.bookshop_modulith.orders.domain.events.CreateOrderRequest;
import com.amagana.bookshop_modulith.orders.domain.events.CreateOrderResponse;
import com.amagana.bookshop_modulith.orders.domain.events.OrderSummary;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);
    OrderSummary getOrder(UUID orderNumber);
    List<OrderSummary> getAllOrders();
}
