package com.amagana.bookshop_modulith.customers.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
}
