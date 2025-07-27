package com.rental.core.damage.mapper;

import com.rental.core.car.mapper.CarMapper;
import com.rental.core.damage.dto.response.DamageDto;
import com.rental.core.damage.model.Damage;
import com.rental.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DamageMapper {

    private final UserMapper userMapper;
    private final CarMapper carMapper;

    public DamageDto toDto(Damage damage){
        return new DamageDto(
                damage.getId(),
                userMapper.toSimpleDto(damage.getUser()),
                carMapper.toSimpleDto(damage.getCar()),
                damage.getDamageDate(),
                damage.getDescription(),
                damage.getRepairCost()
        );
    }
}
