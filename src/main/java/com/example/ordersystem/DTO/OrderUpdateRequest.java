package com.example.ordersystem.DTO;

public record OrderUpdateRequest(Long id, String menuName, Integer quantity) {
}
