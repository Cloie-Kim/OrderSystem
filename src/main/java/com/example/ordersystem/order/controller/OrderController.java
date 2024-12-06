package com.example.ordersystem.order.controller;

import com.example.ordersystem.order.dto.OrderCreateRequest;
import com.example.ordersystem.order.dto.OrderGetResponse;
import com.example.ordersystem.order.dto.OrderUpdateRequest;
import com.example.ordersystem.order.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String addOrder(@RequestBody OrderCreateRequest orderCreateRequest, HttpServletRequest request) {
        Long userId = getLoggedInUser(request);
        return orderService.addOrder(orderCreateRequest, userId);
    }

    @GetMapping
    public OrderGetResponse getOrder(HttpServletRequest request) {
        Long userId = getLoggedInUser(request);
        return orderService.getOrder(userId);
    }

    private static Long getLoggedInUser(HttpServletRequest request) {
        return (Long) request.getSession().getAttribute("loggedInUser");
    }

    @PutMapping
    public String updateOrder(@RequestBody OrderUpdateRequest orderUpdateRequest, HttpServletRequest request) {
        Long userId = getLoggedInUser(request);
        return orderService.updateOrder(orderUpdateRequest, userId);
    }

    @DeleteMapping
    public String deleteAllOrder(HttpServletRequest request) {
        Long userId = getLoggedInUser(request);
        return orderService.deleteAllOrder(userId);
    }
}
