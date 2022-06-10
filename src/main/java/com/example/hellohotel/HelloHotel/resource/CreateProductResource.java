package com.example.hellohotel.HelloHotel.resource;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResource {
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 30)
    private String type;

    @NotBlank
    @NotNull
    private Long stock;

    @NotBlank
    @NotNull
    @Lob
    private String Description;
}
