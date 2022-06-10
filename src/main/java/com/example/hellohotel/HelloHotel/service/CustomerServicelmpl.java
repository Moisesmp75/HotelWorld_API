package com.example.hellohotel.HelloHotel.service;

import com.example.hellohotel.HelloHotel.domain.model.entity.Customer;
import com.example.hellohotel.HelloHotel.domain.model.entity.Hotel;
import com.example.hellohotel.HelloHotel.domain.persistence.CustomerRepository;
import com.example.hellohotel.HelloHotel.domain.service.CustomerService;
import com.example.hellohotel.shared.exception.ResourceNotFoundException;
import com.example.hellohotel.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class CustomerServicelmpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> getAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer","Id",customerId));
    }

    @Override
    public Customer create(Customer customer) {
        Optional<Customer> customer1 = Optional.ofNullable(customerRepository.findByName(customer.getName()));
        if(customer1 != null){
            throw new ResourceValidationException("Customer","An Customer with same name exist alredy");
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Long customer_Id, Customer request) {
        Customer customer1 = customerRepository.findById(customer_Id).orElseThrow(() -> new ResourceNotFoundException("Hotel", "Id", customer_Id));

        return customerRepository.findById(customer_Id).map(hotel ->
                        customerRepository.save(hotel.withName(request.getName())
                                .withLastName(request.getLastName())
                                .withAge(request.getAge())))
                .orElseThrow(()-> new ResourceNotFoundException("Hotel","Customer",customer_Id));
    }

    @Override
    public ResponseEntity<?> delete(Long customerId) {

        return customerRepository.findById(customerId).map(hotel -> {
            customerRepository.delete(hotel);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Customer","Id",customerId));
    }

}
