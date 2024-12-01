package com.example.ordersystem.orderer.dto;

public record OrdererCreateRequest(String ordererName, String email, String password) {
}
