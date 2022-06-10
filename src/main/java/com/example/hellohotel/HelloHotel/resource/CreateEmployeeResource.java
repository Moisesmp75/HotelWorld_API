package com.example.hellohotel.HelloHotel.resource;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeResource {
    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String name;


    @NotNull
    @NotBlank
    @Size(max = 60)
    private String Type;

    @NotNull
    @NotBlank
    private int Salary;
}
