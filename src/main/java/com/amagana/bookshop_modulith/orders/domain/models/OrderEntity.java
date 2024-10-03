package com.amagana.bookshop_modulith.orders.domain.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Orders")
@Builder
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    private UUID orderNumber;

    private Long customerId;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItem = new ArrayList<>();
}
