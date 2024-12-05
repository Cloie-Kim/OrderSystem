package com.example.ordersystem.orderer.service;

import com.example.ordersystem.orderer.dto.LoginRequestDTO;
import com.example.ordersystem.orderer.dto.UserAuthDTO;
import com.example.ordersystem.orderer.dto.UserSessionDTO;
import com.example.ordersystem.orderer.entity.User;
import com.example.ordersystem.orderer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserSessionDTO login(LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByEmail(loginRequestDTO.email())
                .orElseThrow(() -> new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다."));

        UserAuthDTO userAuthDTO = user.toAuthDTO();

        if (!passwordEncoder.matches(loginRequestDTO.password(), userAuthDTO.password())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }

        return user.toSessionDTO();
    }

}
