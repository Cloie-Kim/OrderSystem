package com.example.ordersystem.orderer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orderers")
public class Orderer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ordererId;

    @Column(unique = true, nullable = false)
    private String ordererName;

    protected Orderer() {
    }

    public Orderer(String ordererName) {
        this.ordererName = ordererName;
    }

}
