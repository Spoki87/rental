package com.rental.core.damage.dto.response;

import com.rental.core.car.dto.response.SimpleCarDto;
import com.rental.user.appuser.dto.response.SimpleUserDto;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class DamageDto {
    UUID id;
    SimpleUserDto user;
    SimpleCarDto car;
    LocalDate damageDate;
    String description;
    BigDecimal repairCost;

}
