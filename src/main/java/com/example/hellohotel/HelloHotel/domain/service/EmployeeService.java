package com.example.hellohotel.HelloHotel.domain.service;

import com.example.hellohotel.HelloHotel.domain.model.entity.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    List<Employees> getAll();
    Page<Employees> getAll(Pageable pageable);
    Employees getById(Long Employees_Id);
    Employees create(Employees employees);
    Employees update(Long Employees_Id, Employees request);
    ResponseEntity<?> delete(Long employee_Id);
}
