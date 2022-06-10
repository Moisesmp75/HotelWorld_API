package com.example.hellohotel.HelloHotel.domain.persistence;

import com.example.hellohotel.HelloHotel.domain.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findAllByAge(int age);
    List<Customer> findByDni(String Dni);
    Customer findByName(String name);
}
