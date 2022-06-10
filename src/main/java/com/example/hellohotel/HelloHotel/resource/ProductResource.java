package com.example.hellohotel.HelloHotel.resource;
import lombok.*;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor

public class ProductResource {
    private Long id;
    private String name;
    private String type;
    private Long stock;
    private String Description;
}
