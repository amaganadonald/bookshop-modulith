package com.amagana.bookshop_modulith.orders.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderItem  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_seq")
    @SequenceGenerator(name = "order_item_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    private String bookId;
    private double price;
    private int quantity;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private OrderEntity order;
}
