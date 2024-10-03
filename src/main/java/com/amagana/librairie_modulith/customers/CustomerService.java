package com.amagana.librairie_modulith.customers;

import com.amagana.librairie_modulith.common.PageResult;
import com.amagana.librairie_modulith.customers.domain.CustomerDtoRequest;


public interface CustomerService {

    CustomerDtoResponse createCustomer(CustomerDtoRequest customerDtoRequest);
    CustomerDtoResponse getCustomer(Long id);
    PageResult<CustomerDtoResponse> getAllCustomers(int page, int size);
}
