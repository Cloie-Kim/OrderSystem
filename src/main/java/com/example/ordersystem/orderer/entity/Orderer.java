package com.example.ordersystem.orderer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orderers")
public class Orderer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordererId;

    @Column(nullable = false)
    private String ordererName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    protected Orderer() {
    }

    public Orderer(String ordererName, String email, String password) {
        this.ordererName = ordererName;
        this.email = email;
        this.password = password;
    }

}
