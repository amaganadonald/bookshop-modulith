package com.amagana.bookshop_modulith.customers.domain;

import com.amagana.bookshop_modulith.customers.CustomerDtoResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
class CustomerMapper {
     Customer customerDtoRequestToCustomer(CustomerDtoRequest customerDtoRequest){
        return Customer.builder()
                .email(customerDtoRequest.email())
                .name(customerDtoRequest.name())
                .password(customerDtoRequest.password())
                .phone(customerDtoRequest.phone())
                .build();
    }

     CustomerDtoResponse customerToCustomerDtoResponse(Customer customer){
        return CustomerDtoResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .password(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }
}
