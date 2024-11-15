package com.example.ordersystem.DTO;

import com.example.ordersystem.Entity.Order;

import java.util.List;

public record OrderGetResponse(List<Order> orders) {
}
