package com.example.ordersystem.order.entity;

import com.example.ordersystem.menu.entity.Menu;
import com.example.ordersystem.order.dto.OrderInfo;
import com.example.ordersystem.orderer.entity.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @Column(nullable=false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    protected Order() {
    }

    public Order(Menu menu, User user, Integer quantity) {
        this.menu = menu;
        this.user = user;
        this.quantity = quantity;
    }

    public void update(Integer quantity, Menu menu) {
        this.quantity = quantity;
        this.menu = menu;
    }

    public static List<OrderInfo> toOrderInfoList(List<Order> orders){
        List<OrderInfo> orderInfos = new ArrayList<>();

        for(Order order : orders){
            orderInfos.add(toOrderInfo(order));
        }

        return orderInfos;
    }

    public static OrderInfo toOrderInfo(Order order){
        return new OrderInfo(order.menu.getMenuName(), order.quantity);
    }
}
