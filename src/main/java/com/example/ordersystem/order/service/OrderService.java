package com.example.ordersystem.order.service;

import com.example.ordersystem.menu.entity.Menu;
import com.example.ordersystem.menu.repository.MenuRepository;
import com.example.ordersystem.order.dto.OrderCreateRequest;
import com.example.ordersystem.order.dto.OrderGetResponse;
import com.example.ordersystem.order.dto.OrderUpdateRequest;
import com.example.ordersystem.order.entity.Order;
import com.example.ordersystem.order.repository.OrderRepository;
import com.example.ordersystem.orderer.entity.Orderer;
import com.example.ordersystem.orderer.repository.OrdererRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;
    private final OrdererRepository ordererRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, MenuRepository menuRepository, OrdererRepository ordererRepository) {
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
        this.ordererRepository = ordererRepository;
    }

    @Transactional
    public String addOrder(OrderCreateRequest orderCreateRequest) {
        Menu menu = menuRepository.findById(orderCreateRequest.menuFK())
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu ID"));

        Orderer orderer = ordererRepository.findById(orderCreateRequest.ordererFK())
                .orElseThrow(() -> new IllegalArgumentException("Invalid orderer ID"));

        Order order = new Order(menu, orderer, orderCreateRequest.quantity());

        orderRepository.save(order);
        return "주문 완료";
    }

    public OrderGetResponse getOrder() {
        return new OrderGetResponse(orderRepository.findAll());
    }

    @Transactional
    public String updateOrder(OrderUpdateRequest orderUpdateRequest) {
        Order order = orderRepository.findById(orderUpdateRequest.id()).get();
        Menu menu = menuRepository.findById(orderUpdateRequest.menuFK()).get();
        order.update(orderUpdateRequest.quantity(), menu);
        orderRepository.save(order);
        return "주문 수정 완료";
    }

    @Transactional
    public String deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        orderRepository.delete(order);
        return id + "번 주문이 취소되었습니다.";
    }

    @Transactional
    public String deleteAllOrder() {
        orderRepository.deleteAll();
        return "주문 삭제 완료";
    }
}
