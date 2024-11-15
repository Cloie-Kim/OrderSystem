package com.example.ordersystem.dto;

import com.example.ordersystem.entity.Order;

import java.util.List;

public record OrderGetResponse(List<Order> orders) {
}
