package com.example.ordersystem.orderer.controller;

import com.example.ordersystem.orderer.dto.OrdererCreateRequest;
import com.example.ordersystem.orderer.service.OrdererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderer")
public class OrdererController {
    private OrdererService ordererService;

    @Autowired
    public OrdererController(OrdererService ordererService) {
        this.ordererService = ordererService;
    }

    @PostMapping
    public ResponseEntity<String> addOrderer(@RequestBody OrdererCreateRequest ordererCreateRequest) {
        try {
            ordererService.addOrderer(ordererCreateRequest);

            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "/signupSuccess")
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("회원가입 실패: " + e.getMessage());
        }
    }
}
