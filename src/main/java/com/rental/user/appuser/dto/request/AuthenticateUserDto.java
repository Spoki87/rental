package com.rental.user.appuser.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Valid
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateUserDto {
    @NotBlank(message = "Email is required. Please provide a valid email address")
    @Email(message = "The email format is invalid. Please provide a valid email")
    String email;

    @NotBlank(message = "Password is required")
    String password;
}
