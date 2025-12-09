package com.example.zwigato.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Address {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String houseNo;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private int pinCode;



}
