package com.amagana.librairie_modulith.inventory;

import com.amagana.librairie_modulith.orders.domain.events.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class InventoryService {

    @EventListener
    void on(OrderCreatedEvent event) {
        log.info("Update Inventory for Book : {}", event.orderItems());
    }
}
