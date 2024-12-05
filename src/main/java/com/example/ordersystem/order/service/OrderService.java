package com.example.ordersystem.order.service;

import com.example.ordersystem.menu.entity.Menu;
import com.example.ordersystem.menu.repository.MenuRepository;
import com.example.ordersystem.order.dto.OrderCreateRequest;
import com.example.ordersystem.order.dto.OrderGetResponse;
import com.example.ordersystem.order.dto.OrderUpdateRequest;
import com.example.ordersystem.order.entity.Order;
import com.example.ordersystem.order.repository.OrderRepository;
import com.example.ordersystem.orderer.entity.User;
import com.example.ordersystem.orderer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, MenuRepository menuRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public String addOrder(OrderCreateRequest orderCreateRequest, Long userId) {
        Menu menu = menuRepository.findById(orderCreateRequest.menuFK())
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu ID"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        Order order = new Order(menu, user, orderCreateRequest.quantity());

        orderRepository.save(order);
        return "주문 완료";
    }

    public OrderGetResponse getOrder(Long userId)
    {
        return new OrderGetResponse(orderRepository.findByUserUserId(userId));
    }

    @Transactional
    public String updateOrder(OrderUpdateRequest orderUpdateRequest, Long userId) {
        Order order = orderRepository.findById(userId).get();
        Menu menu = menuRepository.findById(orderUpdateRequest.menuFK()).get();
        order.update(orderUpdateRequest.quantity(), menu);
        orderRepository.save(order);
        return "주문 수정 완료";
    }

    @Transactional
    public String deleteAllOrder(Long userId) {
        orderRepository.deleteAll();
        return "주문 삭제 완료";
    }
}
