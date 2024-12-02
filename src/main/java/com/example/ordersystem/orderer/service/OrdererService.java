package com.example.ordersystem.orderer.service;

import com.example.ordersystem.orderer.dto.OrdererCreateRequestDTO;
import com.example.ordersystem.orderer.entity.Orderer;
import com.example.ordersystem.orderer.repository.OrdererRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrdererService {
    private final OrdererRepository ordererRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public OrdererService(OrdererRepository ordererRepository, PasswordEncoder passwordEncoder) {
        this.ordererRepository = ordererRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void addOrderer(OrdererCreateRequestDTO ordererCreateRequestDTO) {
        if (ordererRepository.findByEmail(ordererCreateRequestDTO.email()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 등록된 이메일입니다.");
        }

        Orderer orderer = new Orderer(
                ordererCreateRequestDTO.ordererName(),
                ordererCreateRequestDTO.email(),
                passwordEncoder.encode(ordererCreateRequestDTO.password())
        );

        ordererRepository.save(orderer);
    }

}
