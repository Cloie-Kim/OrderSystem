package com.example.ordersystem.orderer.dto;

public record OrdererAuthDTO(Long ordererId, String name, String email, String password) {
}
