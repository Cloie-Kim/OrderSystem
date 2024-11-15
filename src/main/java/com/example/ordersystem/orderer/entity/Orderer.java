package com.example.ordersystem.orderer.entity;

import com.example.ordersystem.order.entity.Order;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orderers")
public class Orderer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ordererId;

    @Column(unique = true, nullable = false)
    private String ordererName;

    @OneToMany(mappedBy = "order")
    private List<Order> order;
}
