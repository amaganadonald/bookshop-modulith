package com.amagana.librairie_modulith.orders.domain.models;

import com.amagana.librairie_modulith.catalog.BookService;
import com.amagana.librairie_modulith.customers.CustomerDtoResponse;
import com.amagana.librairie_modulith.customers.CustomerService;
import com.amagana.librairie_modulith.orders.domain.events.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final BookService bookService;
    private final CustomerService customerService;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        List<OrderItem> orderItems = validate(createOrderRequest);
        CustomerDtoResponse customerDtoResponse = getCustomer(createOrderRequest.CustomerId());
        OrderEntity newOrder = OrderMapper.createOrderRequestToOrderEntity(createOrderRequest
                , customerDtoResponse.id());
        newOrder.setOrderItem(orderItems);
        OrderEntity saveOrder = orderRepository.save(newOrder);
        log.info("Created Order with orderNumber={}", saveOrder.getOrderNumber());
        OrderCreatedEvent event = new OrderCreatedEvent(saveOrder.getOrderNumber(), saveOrder.getOrderItem());
        eventPublisher.publishEvent(event);
        return new CreateOrderResponse(saveOrder.getOrderNumber(), customerDtoResponse, orderItems);
    }

    @Override
    public OrderSummary getOrder(UUID orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new OrderNotFoundException(String.format("Order with number: %s not found", orderNumber)));
    }

    @Override
    public List<OrderSummary> getAllOrders() {
        return orderRepository.findAllBy();
    }

    private List<OrderItem> validate(CreateOrderRequest request) {
        List<OrderItem> orderDtoList = new ArrayList<>();
        for (OrderDto order: request.orderDto()) {
            var book = bookService.getBookByIsbn(order.bookId());
            if(book.price() == order.price()) {
                orderDtoList.add(OrderMapper.orderDtoToOrderItem(order));
            }
        }
        if (!orderDtoList.isEmpty())
            return orderDtoList;
        throw new InvalidOrderException("Order Invalid");
    }

    private CustomerDtoResponse getCustomer(Long id) {
        return customerService.getCustomer(id);
    }
}
