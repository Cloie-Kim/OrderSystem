package com.example.ordersystem.order.service;

import com.example.ordersystem.order.dto.OrderCreateRequest;
import com.example.ordersystem.order.dto.OrderGetResponse;
import com.example.ordersystem.order.dto.OrderUpdateRequest;
import com.example.ordersystem.order.entity.Order;
import com.example.ordersystem.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String addOrder(OrderCreateRequest orderCreateRequest) {
        Order order = new Order(orderCreateRequest.menuName(), orderCreateRequest.quantity());
        orderRepository.save(order);
        return "주문 완료";
    }

    public OrderGetResponse getOrder() {
        return new OrderGetResponse(orderRepository.findAll());
    }


    public String updateOrder(OrderUpdateRequest orderUpdateRequest) {
        Order order = orderRepository.findById(orderUpdateRequest.id()).get();
        order.update(orderUpdateRequest.menuName(), orderUpdateRequest.quantity());
        orderRepository.save(order);
        return "주문 수정 완료";
    }

    public String deleteOrder() {
        orderRepository.deleteAll();
        return "주문 삭제 완료";
    }
}
