package com.example.ordersystem.order.entity;

import com.example.ordersystem.menu.entity.Menu;
import com.example.ordersystem.orderer.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @Column(nullable=false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
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
