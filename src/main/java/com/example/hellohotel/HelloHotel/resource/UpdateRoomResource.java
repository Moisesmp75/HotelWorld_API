package com.example.hellohotel.HelloHotel.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateRoomResource {
    @NotNull
    @NotBlank
    private String state;

    @NotNull
    @NotBlank
    private int beds;

    @NotNull
    @NotBlank
    private String Description;

}
