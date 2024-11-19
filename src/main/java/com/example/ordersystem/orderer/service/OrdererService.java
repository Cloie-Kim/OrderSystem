package com.example.ordersystem.orderer.service;

import com.example.ordersystem.orderer.dto.OrdererCreateRequest;
import com.example.ordersystem.orderer.entity.Orderer;
import com.example.ordersystem.orderer.repository.OrdererRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdererService {
    private OrdererRepository ordererRepository;

    @Autowired
    public OrdererService(OrdererRepository ordererRepository) {
        this.ordererRepository = ordererRepository;
    }

    public String addOrderer(OrdererCreateRequest ordererCreateRequest) {
        Orderer orderer = new Orderer(ordererCreateRequest.ordererName());
        ordererRepository.save(orderer);
        return ordererCreateRequest.ordererName() + "님, 환영해요!";
    }
}
