package com.amagana.librairie_modulith.orders.domain.models;

import com.amagana.librairie_modulith.orders.domain.events.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


    List<OrderSummary> findAllBy();

    Optional<OrderSummary> findByOrderNumber(UUID orderNumber);
}
