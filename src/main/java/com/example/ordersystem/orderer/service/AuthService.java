package com.example.ordersystem.orderer.service;

import com.example.ordersystem.orderer.dto.LoginRequestDTO;
import com.example.ordersystem.orderer.dto.OrdererAuthDTO;
import com.example.ordersystem.orderer.dto.OrdererSessionDTO;
import com.example.ordersystem.orderer.entity.Orderer;
import com.example.ordersystem.orderer.repository.OrdererRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final OrdererRepository ordererRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(OrdererRepository ordererRepository, PasswordEncoder passwordEncoder) {
        this.ordererRepository = ordererRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public OrdererSessionDTO login(LoginRequestDTO loginRequestDTO) {
        Orderer orderer = ordererRepository.findByEmail(loginRequestDTO.email())
                .orElseThrow(() -> new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다."));

        OrdererAuthDTO ordererAuthDTO = orderer.toAuthDTO();

        if (!passwordEncoder.matches(loginRequestDTO.password(), ordererAuthDTO.password())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }

        return orderer.toSessionDTO();
    }

}
