package com.example.ordersystem.order.dto;

import com.example.ordersystem.order.entity.Order;

import java.util.List;

public record OrderGetResponse(List<Order> orders) {
}
