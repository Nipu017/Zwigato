package com.example.zwigato.model;

import com.example.zwigato.utility.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Customer {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(nullable = false,length = 10)
    private String mobNo;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn()
    private List<Address> address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderEntity>orders;
}
