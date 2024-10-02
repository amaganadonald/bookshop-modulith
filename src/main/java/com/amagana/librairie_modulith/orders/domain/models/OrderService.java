package com.amagana.librairie_modulith.orders.domain.models;

import com.amagana.librairie_modulith.orders.domain.events.CreateOrderRequest;
import com.amagana.librairie_modulith.orders.domain.events.CreateOrderResponse;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);
}
