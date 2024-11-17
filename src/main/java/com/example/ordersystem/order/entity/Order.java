package com.example.ordersystem.order.entity;

import com.example.ordersystem.menu.entity.Menu;
import com.example.ordersystem.orderer.entity.Orderer;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "ordererFK")
    private Orderer orderer;

    @ManyToOne
    @JoinColumn(name = "menuFK")
    private Menu menu;

    protected Order() {
    }

    public Order(Menu menu, Orderer orderer, Integer quantity) {
        this.menu = menu;
        this.orderer = orderer;
        this.quantity = quantity;
    }

    public void update(Integer quantity, Menu menu) {

        this.quantity = quantity;
        this.menu = menu;
    }
}
