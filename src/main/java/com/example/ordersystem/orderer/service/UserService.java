package com.example.ordersystem.orderer.service;

import com.example.ordersystem.orderer.dto.UserCreateRequestDTO;
import com.example.ordersystem.orderer.entity.User;
import com.example.ordersystem.orderer.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void addUser(UserCreateRequestDTO userCreateRequestDTO) {
        if (userRepository.findByEmail(userCreateRequestDTO.email()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 등록된 이메일입니다.");
        }

        User user = new User(
                userCreateRequestDTO.userName(),
                userCreateRequestDTO.email(),
                passwordEncoder.encode(userCreateRequestDTO.password())
        );

        userRepository.save(user);
    }

}
