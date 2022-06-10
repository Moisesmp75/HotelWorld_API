package com.example.hellohotel.HelloHotel.resource;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
@Setter
public class UpdateCustomerResource {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private int age;

    @NotNull
    @NotBlank
    private String LastName;
}
