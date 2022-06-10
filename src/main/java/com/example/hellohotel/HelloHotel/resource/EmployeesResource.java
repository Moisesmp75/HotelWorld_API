package com.example.hellohotel.HelloHotel.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesResource {
    private Long id;
    private String name;
    private String Type;
    private int Salary;
}
