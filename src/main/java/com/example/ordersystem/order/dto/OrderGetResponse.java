package com.example.ordersystem.order.dto;

import com.example.ordersystem.order.entity.Order;

import java.util.List;
import java.util.Optional;

public record OrderGetResponse(List<OrderInfo> orders) {
}
