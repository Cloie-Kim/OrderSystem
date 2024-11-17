package com.example.ordersystem.order.entity;

import com.example.ordersystem.menu.entity.Menu;
import com.example.ordersystem.orderer.entity.Orderer;
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

    @ManyToOne
    @JoinColumn(name = "menuId")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "ordererId")
    private Orderer orderer;

    protected Order() {
    }

    public Order(String menuName, Integer quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
    }

    public void update(String menuName, Integer quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
    }
}
