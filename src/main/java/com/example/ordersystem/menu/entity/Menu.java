package com.example.ordersystem.menu.entity;

import jakarta.persistence.*;

@Entity
@Table(name="menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(unique = true, nullable = false)
    private String menuName;

    @Column(nullable = false)
    private Integer price;

    public String getMenuName() {
        return menuName;
    }

}
