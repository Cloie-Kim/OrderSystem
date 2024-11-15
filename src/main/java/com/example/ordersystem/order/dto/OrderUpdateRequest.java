package com.example.ordersystem.order.dto;

public record OrderUpdateRequest(Long id, String menuName, Integer quantity) {
}
