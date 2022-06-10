package com.example.hellohotel.HelloHotel.resource;
import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateHotelResource {
    @NotBlank
    @NotNull
    @Size(max = 100)
    private String name;
    @NotBlank
    @Lob
    private String description;
    @NotBlank
    @Size(max=300)
    private String location;
}