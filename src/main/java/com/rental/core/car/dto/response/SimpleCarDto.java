package com.rental.core.car.dto.response;

import lombok.Value;

import java.util.UUID;

@Value
public class SimpleCarDto {
    UUID id;
    String name;
}
