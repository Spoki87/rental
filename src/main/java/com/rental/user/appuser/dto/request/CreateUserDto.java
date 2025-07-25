package com.rental.user.appuser.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class CreateUserDto {
    @NotBlank(message = "First name is required. Please provide a valid username")
    @Size(max = 255, message = "First name cannot be longer than 255 letters")
    String firstName;

    @NotBlank(message = "Last name is required. Please provide a valid last name")
    @Size(max = 255, message = "Last name cannot be longer than 255 letters")
    String lastName;

    @NotBlank(message = "Email is required. Please provide a valid email address")
    @Email(message = "The email format is invalid. Please provide a valid email")
    String email;

    @NotBlank(message = "Password is required. Please provide a secure password")
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters long")
    String password;
}
