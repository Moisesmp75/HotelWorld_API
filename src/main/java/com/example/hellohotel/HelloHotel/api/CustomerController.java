package com.example.hellohotel.HelloHotel.api;

import com.example.hellohotel.HelloHotel.domain.service.CustomerService;
import com.example.hellohotel.HelloHotel.mapping.CustomerMapper;
import com.example.hellohotel.HelloHotel.resource.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper mapper;

    public CustomerController(CustomerService customerService, CustomerMapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }
    @GetMapping
    public Page<CustomerResource> getAll(Pageable pageable) {
        return mapper.modelListPage(customerService.getAll(), pageable);
    }

    @GetMapping("customerId")
    public CustomerResource getCustomerById(@PathVariable Long CustomerId){
        return mapper.toResource(customerService.getById(CustomerId));
    }

    @GetMapping
    public CustomerResource createCustomer(@RequestBody CreateCustomerResource resource){
        return mapper.toResource(customerService.create(mapper.toModel(resource)));
    }

    @GetMapping("customerId")
    public CustomerResource updateHotel(@PathVariable Long HotelId, @RequestBody UpdateCustomerResource resource){
        return mapper.toResource(customerService.update(HotelId,mapper.toModel(resource)));
    }

    @GetMapping("{customerId}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long hotelId){
        return customerService.delete(hotelId);
    }



}
