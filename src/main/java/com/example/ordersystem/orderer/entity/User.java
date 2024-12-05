package com.example.ordersystem.orderer.entity;

import com.example.ordersystem.order.entity.Order;
import com.example.ordersystem.global.auth.dto.UserAuthDTO;
import com.example.ordersystem.global.auth.dto.UserSessionDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Order> orders=new ArrayList<>();

    protected User() {
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public UserAuthDTO toAuthDTO() {
        return new UserAuthDTO(this.userId, this.userName, this.email, this.password);
    }

    public UserSessionDTO toSessionDTO() {
        return new UserSessionDTO(this.userId);
    }


}
