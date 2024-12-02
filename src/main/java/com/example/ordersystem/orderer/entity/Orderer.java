package com.example.ordersystem.orderer.entity;

import com.example.ordersystem.orderer.dto.OrdererAuthDTO;
import com.example.ordersystem.orderer.dto.OrdererSessionDTO;
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

    public OrdererAuthDTO toAuthDTO() {
        return new OrdererAuthDTO(this.ordererId, this.ordererName, this.email, this.password);
    }

    public OrdererSessionDTO toSessionDTO() {
        return new OrdererSessionDTO(this.ordererId);
    }


}
