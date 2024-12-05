package com.example.ordersystem.order.entity;

import com.example.ordersystem.menu.entity.Menu;
import com.example.ordersystem.orderer.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "userFK")
    private User user;

    @ManyToOne
    @JoinColumn(name = "menuFK")
    private Menu menu;

    protected Order() {
    }

    public Order(Menu menu, User user, Integer quantity) {
        this.menu = menu;
        this.user = user;
        this.quantity = quantity;
    }

    public void update(Integer quantity, Menu menu) {

        this.quantity = quantity;
        this.menu = menu;
    }
}
