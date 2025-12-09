package com.example.zwigato.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private boolean isOpen;

    @Column
    private Date registerAt;

    @ManyToMany(mappedBy = "restaurants")
    @JsonIgnore
    private List<MenuItem> menuItem;

}
