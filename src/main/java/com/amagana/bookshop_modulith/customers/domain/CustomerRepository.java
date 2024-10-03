package com.amagana.bookshop_modulith.customers.domain;

import com.amagana.bookshop_modulith.customers.CustomerDtoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Page<CustomerDtoResponse> findAllBy(Pageable pageable);
}
