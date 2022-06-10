package com.example.hellohotel.HelloHotel.resource;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerResource {

    @NotNull
    @Column(unique=true)
    @Size(max=60)
    private String name;

    @NotNull
    @Lob
    private String description;

    @NotNull
    @Lob
    private String Location;

    @NotNull
    @NotBlank
    private int phone;

}
