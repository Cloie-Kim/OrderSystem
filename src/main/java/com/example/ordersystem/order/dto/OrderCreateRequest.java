package com.example.ordersystem.order.dto;

public record OrderCreateRequest(Long menuFK, Long ordererFK, Integer quantity) {
}
