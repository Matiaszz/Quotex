package com.inzora.quotex.application.dtos;

import com.inzora.quotex.domain.investment.Investment;
import com.inzora.quotex.domain.user.User;
import com.inzora.quotex.enums.UserRole;

import java.util.List;

public record UserResponseDTO(
        String id,
        String username,
        String email,
        UserRole role,
        boolean enabled,
        List<Investment> investments
){
    public UserResponseDTO(User user){
        this(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                user.getEnabled(),
                user.getInvestments()
        );
    }
}
