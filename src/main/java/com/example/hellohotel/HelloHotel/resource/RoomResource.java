package com.example.hellohotel.HelloHotel.resource;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class RoomResource {
    private Long id;
    private String state;
    private int beds;
    private String Description;
    private int roomNumber;
}
