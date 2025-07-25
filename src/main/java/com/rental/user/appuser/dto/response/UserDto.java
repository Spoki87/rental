package com.rental.user.appuser.dto.response;

import com.rental.user.appuser.model.Role;
import lombok.Value;

import java.util.UUID;

@Value
public class UserDto {
    UUID id;
    String email;
    Role role;
}
