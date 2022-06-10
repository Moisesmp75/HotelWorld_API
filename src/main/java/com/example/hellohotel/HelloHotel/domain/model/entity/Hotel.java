package com.example.hellohotel.HelloHotel.domain.model.entity;

import com.example.hellohotel.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "hotel")
public class Hotel extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique=true)
    private String name;
    @NotNull
    @Lob
    private String description;
    @NotNull
    @Lob
    private String Location;

    @Column
    private int phone;

    //relations
    @OneToMany(fetch = FetchType.LAZY,
    cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="Room_Id")
    @JsonIgnore
    private List<room> rooms;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="products_id",nullable = false)
    @JsonIgnore
    private List<Product> products;


}
