package com.example.ordersystem.Entity;

import jakarta.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String menuName;

    @Column
    private Integer quantity;

    @Column
    private double price;

    public Order(){}

    public Order(String menuName, Integer quantity, double price) {
        this.menuName = menuName;
        this.quantity = quantity;
        this.price = price;
    }
}
