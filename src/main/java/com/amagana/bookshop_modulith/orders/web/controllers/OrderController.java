package com.amagana.bookshop_modulith.orders.web.controllers;

import com.amagana.bookshop_modulith.orders.domain.events.CreateOrderRequest;
import com.amagana.bookshop_modulith.orders.domain.events.CreateOrderResponse;
import com.amagana.bookshop_modulith.orders.domain.events.OrderSummary;
import com.amagana.bookshop_modulith.orders.domain.models.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
@Slf4j
class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreateOrderResponse createOrder(@Valid @RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<OrderSummary> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderNumber}")
    @ResponseStatus(HttpStatus.OK)
    OrderSummary getOrder(@PathVariable(name = "orderNumber") UUID orderNumber) {
        log.info("Fetching order by number: {}", orderNumber);
        return orderService.getOrder(orderNumber);
    }
}
