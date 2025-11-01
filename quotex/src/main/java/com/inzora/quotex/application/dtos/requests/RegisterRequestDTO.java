package com.inzora.quotex.application.dtos.requests;

import com.inzora.quotex.enums.InvestmentProfile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record RegisterRequestDTO(
        @NotNull
        String username,

        @Email
        @NotNull
        String email,

        @NotNull
        String password,

        @NotNull
        InvestmentProfile investmentProfile
) {

}
