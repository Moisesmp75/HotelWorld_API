package com.example.hellohotel.HelloHotel.service;

import com.example.hellohotel.HelloHotel.domain.model.entity.Employees;
import com.example.hellohotel.HelloHotel.domain.model.entity.Hotel;
import com.example.hellohotel.HelloHotel.domain.persistence.EmployeesRepository;
import com.example.hellohotel.HelloHotel.domain.service.EmployeeService;
import com.example.hellohotel.shared.exception.ResourceNotFoundException;
import com.example.hellohotel.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class EmployeesServicelpml implements EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public List<Employees> getAll() {return employeesRepository.findAll();}

    @Override
    public Page<Employees> getAll(Pageable pageable) {
        return employeesRepository.findAll(pageable);
    }

    @Override
    public Employees getById(Long Employees_Id) {
        return employeesRepository.findById(Employees_Id).orElseThrow(() -> new ResourceNotFoundException("employee","Id",Employees_Id));
    }

    @Override
    public Employees create(Employees employees) {
        Optional<Employees> employees1 = employeesRepository.findById(employees.getId());
        if(employees1!=null){
            throw new ResourceValidationException("employee","An employees with same name exist alredy");
        }
        return employeesRepository.save(employees);
    }

    @Override
    public Employees update(Long Employees_Id, Employees request) {
        Employees employees1 = employeesRepository.findById(Employees_Id).orElseThrow(() -> new ResourceNotFoundException("Hotel", "Id", Employees_Id));

        return employeesRepository.findById(Employees_Id).map(hotel ->
                        employeesRepository.save(hotel.withName(request.getName())
                                .withSalary(request.getSalary())
                                .withType(request.getType())))
                .orElseThrow(()-> new ResourceNotFoundException("employee","Id",Employees_Id));
    }

    @Override
    public ResponseEntity<?> delete(Long employee_Id) {
        return employeesRepository.findById(employee_Id).map(hotel -> {
            employeesRepository.delete(hotel);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("employee","Id",employee_Id));
    }
}
