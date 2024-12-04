package com.example.ordersystem.orderer.controller;

import com.example.ordersystem.orderer.dto.LoginRequestDTO;
import com.example.ordersystem.orderer.dto.OrdererSessionDTO;
import com.example.ordersystem.orderer.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpSession session) {
        try {
            OrdererSessionDTO sessionDTO = authService.login(loginRequestDTO);
            session.setAttribute("loggedInUser", sessionDTO.ordererId());
            return ResponseEntity.ok("로그인 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("로그인 실패: " + e.getMessage());
        }
    }

}
