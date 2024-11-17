package com.example.ordersystem.menu.entity;

import com.example.ordersystem.order.entity.Order;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(unique = true, nullable = false)
    private String menuName;

    @Column(unique = true, nullable = false)
    private Integer price;

}
