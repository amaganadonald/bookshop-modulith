package com.amagana.bookshop_modulith.customers.web;

import com.amagana.bookshop_modulith.common.PageResult;
import com.amagana.bookshop_modulith.customers.domain.CustomerDtoRequest;
import com.amagana.bookshop_modulith.customers.CustomerDtoResponse;
import com.amagana.bookshop_modulith.customers.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CustomerDtoResponse createCustomer(@Valid @RequestBody CustomerDtoRequest customerDtoRequest) {
        return customerService.createCustomer(customerDtoRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CustomerDtoResponse getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    PageResult<CustomerDtoResponse> getAllCustomers(@RequestParam(name = "page", defaultValue = "0") int page,
                                                    @RequestParam(name = "size", defaultValue = "5") int size) {
        return customerService.getAllCustomers(page, size);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CustomerDtoResponse updateCustomer(@PathVariable Long id, @RequestBody CustomerDtoRequest customerDtoRequest) {
        return customerService.updateCustomer(id, customerDtoRequest);
    }
}
