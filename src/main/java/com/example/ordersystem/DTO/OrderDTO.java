package com.example.ordersystem.DTO;

public record OrderDTO(
        Long id,
        String menuName,
        Integer quantity,
        Double price
) {}

