package com.amagana.bookshop_modulith.customers;

import com.amagana.bookshop_modulith.common.PageResult;
import com.amagana.bookshop_modulith.customers.domain.CustomerDtoRequest;


public interface CustomerService {

    CustomerDtoResponse createCustomer(CustomerDtoRequest customerDtoRequest);
    CustomerDtoResponse getCustomer(Long id);
    PageResult<CustomerDtoResponse> getAllCustomers(int page, int size);
    CustomerDtoResponse updateCustomer(Long id, CustomerDtoRequest customerDtoRequest);
}
