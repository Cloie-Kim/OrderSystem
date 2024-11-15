package com.example.ordersystem.dto;

public record OrderUpdateRequest(Long id, String menuName, Integer quantity) {
}
