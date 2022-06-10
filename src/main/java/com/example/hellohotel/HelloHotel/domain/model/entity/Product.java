package com.example.hellohotel.HelloHotel.domain.model.entity;

import com.example.hellohotel.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Products")
public class Product extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
    private String type;

    @Column
    private Long stock;

    @Column
    @Lob
    private String Description;

    //relationsShips
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="Hotel_id",nullable = false)
    @JsonIgnore
    private Hotel hotel;

}
