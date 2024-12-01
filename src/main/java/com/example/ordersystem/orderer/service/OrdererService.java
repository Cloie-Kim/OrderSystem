package com.example.ordersystem.orderer.service;

import com.example.ordersystem.orderer.dto.OrdererCreateRequest;
import com.example.ordersystem.orderer.entity.Orderer;
import com.example.ordersystem.orderer.repository.OrdererRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrdererService {
    private OrdererRepository ordererRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public OrdererService(OrdererRepository ordererRepository, PasswordEncoder passwordEncoder) {
        this.ordererRepository = ordererRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String addOrderer(OrdererCreateRequest ordererCreateRequest) {
        if (ordererRepository.findByEmail(ordererCreateRequest.email()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 등록된 이메일입니다.");
        }

        Orderer orderer = new Orderer(
                ordererCreateRequest.ordererName(),
                ordererCreateRequest.email(),
                passwordEncoder.encode(ordererCreateRequest.password())
        );

        ordererRepository.save(orderer);
        return ordererCreateRequest.ordererName() + "님, 환영해요!";
    }

}
