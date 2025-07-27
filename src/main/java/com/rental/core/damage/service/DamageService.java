package com.rental.core.damage.service;

import com.rental.core.damage.dto.request.CreateDamageDto;
import com.rental.core.damage.dto.request.UpdateDamageDto;
import com.rental.core.damage.dto.response.DamageDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface DamageService {
    DamageDto getDamageById(UUID id);
    Page<DamageDto> getDamages(int page, int size);
    DamageDto createDamage(CreateDamageDto createDamageDto);
    void updateDamage(UUID id, UpdateDamageDto updateDamageDto);
    void deleteDamage(UUID id);
}
