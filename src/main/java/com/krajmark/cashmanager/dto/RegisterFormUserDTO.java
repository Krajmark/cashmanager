package com.krajmark.cashmanager.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record RegisterFormUserDTO(
        @NotNull
        @Size(min = 4, message = "Username should be at least 4 characters.")
        String username,
        @NotNull
        @Size(min = 6, message = "Password should be at least 6 characters.")
        String password
) {
}
