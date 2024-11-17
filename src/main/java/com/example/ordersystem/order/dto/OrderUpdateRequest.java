package com.example.ordersystem.order.dto;

public record OrderUpdateRequest(Long id, Long menuFK, Integer quantity) {
}
