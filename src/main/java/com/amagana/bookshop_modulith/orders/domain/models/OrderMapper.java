package com.amagana.bookshop_modulith.orders.domain.models;

import com.amagana.bookshop_modulith.orders.domain.events.CreateOrderRequest;
import com.amagana.bookshop_modulith.orders.domain.events.OrderDto;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class OrderMapper {

    public OrderEntity createOrderRequestToOrderEntity(CreateOrderRequest request, Long customerId) {
        return OrderEntity.builder()
                .orderNumber(UUID.randomUUID())
                .customerId(customerId)
                .build();
    }

    public OrderItem orderDtoToOrderItem(OrderDto orderDto) {
        return OrderItem.builder()
                .bookId(orderDto.bookId())
                .price(orderDto.price())
                .quantity(orderDto.quantity())
                .build();
    }
}
