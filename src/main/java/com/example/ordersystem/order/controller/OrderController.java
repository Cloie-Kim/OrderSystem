package com.example.ordersystem.order.controller;

import com.example.ordersystem.order.dto.OrderCreateRequest;
import com.example.ordersystem.order.dto.OrderGetResponse;
import com.example.ordersystem.order.dto.OrderUpdateRequest;
import com.example.ordersystem.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String addOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        return orderService.addOrder(orderCreateRequest);
    }

    @GetMapping
    public OrderGetResponse getOrder() {
        return orderService.getOrder();
    }

    @PutMapping
    public String updateOrder(@RequestBody OrderUpdateRequest orderUpdateRequest) {
        return orderService.updateOrder(orderUpdateRequest);
    }

    @DeleteMapping
    public String deleteAllOrder() {
        return orderService.deleteAllOrder();
    }
}
