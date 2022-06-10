package com.example.hellohotel.HelloHotel.resource;

import lombok.*;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResource {
    private Long Id;
    private String name;
    private int age;
    private String LastName;
    private String Dni;
}
