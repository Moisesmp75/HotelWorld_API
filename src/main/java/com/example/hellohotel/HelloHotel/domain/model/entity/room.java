package com.example.hellohotel.HelloHotel.domain.model.entity;

import com.example.hellohotel.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "room")
public class room extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String state;

    @NotNull
    private int beds;

    @NotNull
    private String Description;

    @Column
    private Long roomNumber;

    //relationShip
    @ManyToOne(fetch = FetchType.LAZY,
    cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;

}
