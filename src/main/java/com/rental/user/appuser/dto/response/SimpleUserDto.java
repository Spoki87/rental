package com.rental.user.appuser.dto.response;

import lombok.Value;

import java.util.UUID;

@Value
public class SimpleUserDto {
    UUID id;
    String email;
}
