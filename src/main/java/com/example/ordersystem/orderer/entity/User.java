package com.example.ordersystem.orderer.entity;

import com.example.ordersystem.orderer.dto.UserAuthDTO;
import com.example.ordersystem.orderer.dto.UserSessionDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
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
