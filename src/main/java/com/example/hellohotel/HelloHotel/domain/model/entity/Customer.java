package com.example.hellohotel.HelloHotel.domain.model.entity;

import com.example.hellohotel.shared.domain.model.AuditModel;
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
@Entity
@Table(name = "Customer")
public class Customer extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String name;

    @Column
    private int age;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String LastName;

    @NotNull
    @NotBlank
    @Size(max = 8)
    @Column(unique = true)
    private String Dni;

}
