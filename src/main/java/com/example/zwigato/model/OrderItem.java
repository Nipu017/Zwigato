package com.example.zwigato.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;
}
