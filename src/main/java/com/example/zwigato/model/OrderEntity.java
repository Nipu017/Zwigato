package com.example.zwigato.model;

import com.example.zwigato.utility.enums.OrderStatus;
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
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private double totalCost;

    @Column
    private Date CreatedAt;

    @Column
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "orderEntity")
    @JsonIgnore
    private List<OrderItem>orderItems;
}
