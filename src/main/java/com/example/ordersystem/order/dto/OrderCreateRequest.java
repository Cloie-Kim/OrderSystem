package com.example.ordersystem.order.dto;

public record OrderCreateRequest(Long menuFK, Integer quantity) {
}
