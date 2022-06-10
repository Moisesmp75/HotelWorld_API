package com.example.hellohotel.HelloHotel.resource;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoomResource {
    @NotNull
    @NotBlank
    private String state;

    @NotNull
    @NotBlank
    private int beds;

    @NotNull
    @NotBlank
    @Lob
    private String Description;

    @NotNull
    private int roomNumber;
}
