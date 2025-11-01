package com.inzora.quotex.application.controllers;

import com.inzora.quotex.application.dtos.UserResponseDTO;
import com.inzora.quotex.application.dtos.requests.RegisterRequestDTO;
import com.inzora.quotex.domain.user.User;
import com.inzora.quotex.domain.user.UserRepository;
import com.inzora.quotex.domain.user.UserService;
import com.inzora.quotex.infrastructure.TokenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid RegisterRequestDTO data){
        User user = userService.registerUser(data);
        return tokenService.generateUserTokenAndCreateCookie(user);
    }
}
