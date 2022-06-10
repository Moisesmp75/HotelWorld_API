package com.example.hellohotel.HelloHotel.domain.service;

import com.example.hellohotel.HelloHotel.domain.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<Customer> getAll();
    Page<Customer> getAll(Pageable pageable);
    Customer getById(Long customerId);
    Customer create(Customer customer);
    Customer update(Long customer_Id, Customer request);
    ResponseEntity<?> delete(Long customerId);
}
