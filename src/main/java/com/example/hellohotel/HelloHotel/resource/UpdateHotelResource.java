package com.example.hellohotel.HelloHotel.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateHotelResource {
    private Long id;
    @NotNull
    @NotBlank
    @Size(max=100)
    private String name;
    @NotNull
    @NotBlank
    @Lob
    private String description;
    @NotNull
    @NotBlank
    @Size(max=300)
    private String Location;
}
