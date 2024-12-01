package com.example.ordersystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String menuName;

    @Column
    private Integer quantity;

    protected Order(){}

    public Order(String menuName, Integer quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
    }

    public void update(String menuName, Integer quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
    }
}
