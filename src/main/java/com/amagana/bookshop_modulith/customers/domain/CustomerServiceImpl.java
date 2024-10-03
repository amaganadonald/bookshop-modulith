package com.amagana.bookshop_modulith.customers.domain;

import com.amagana.bookshop_modulith.common.PageResult;
import com.amagana.bookshop_modulith.customers.CustomerDtoResponse;
import com.amagana.bookshop_modulith.customers.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDtoResponse createCustomer(CustomerDtoRequest customerDtoRequest) {
        return CustomerMapper.customerToCustomerDtoResponse(
                customerRepository.save(CustomerMapper.customerDtoRequestToCustomer(customerDtoRequest))
        );
    }

    public Customer findCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException("Customer with this id not found: "+ id));
    }

    @Override
    public CustomerDtoResponse getCustomer(Long id) {
        return CustomerMapper.customerToCustomerDtoResponse(findCustomer(id));
    }

    @Override
    public PageResult<CustomerDtoResponse> getAllCustomers(int page, int size) {
        Page<CustomerDtoResponse> customerDtoResponses = customerRepository.findAllBy(PageRequest.of(page, size));
        return new PageResult<>(customerDtoResponses);
    }

    @Override
    public CustomerDtoResponse updateCustomer(Long id, CustomerDtoRequest customerDtoRequest) {
        Customer customer = findCustomer(id);
        customer.setEmail(customerDtoRequest.email());
        customer.setName(customerDtoRequest.email());
        customer.setPhone(customerDtoRequest.phone());
        return CustomerMapper.customerToCustomerDtoResponse(customerRepository.save(customer));
    }
}
