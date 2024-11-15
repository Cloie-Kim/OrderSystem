package com.example.ordersystem.controller;

import com.example.ordersystem.dto.OrderCreateRequest;
import com.example.ordersystem.dto.OrderGetResponse;
import com.example.ordersystem.dto.OrderUpdateRequest;
import com.example.ordersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/order")
    public String addOrder(@RequestBody OrderCreateRequest orderCreateRequest){
        return orderService.addOrder(orderCreateRequest);
    }

    @GetMapping("/order")
    public OrderGetResponse getOrder() {
        return orderService.getOrder();
    }

    @PutMapping("/order")
    public String updateOrder(@RequestBody OrderUpdateRequest orderUpdateRequest){
        return orderService.updateOrder(orderUpdateRequest);
    }

    @DeleteMapping("/order")
    public String deleteOrder(){
        return orderService.deleteOrder();
    }
}
