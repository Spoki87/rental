package com.rental.core.damage.controller;

import com.rental.core.car.dto.request.CreateCarDto;
import com.rental.core.car.dto.request.UpdateCarDto;
import com.rental.core.car.dto.response.CarDto;
import com.rental.core.damage.dto.request.CreateDamageDto;
import com.rental.core.damage.dto.request.UpdateDamageDto;
import com.rental.core.damage.dto.response.DamageDto;
import com.rental.core.damage.service.DamageService;
import com.rental.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/damages")
@RequiredArgsConstructor
@Validated
public class DamageController {
    private final DamageService damageService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<DamageDto>> getDamageById(@PathVariable UUID id){
        DamageDto damageDto = damageService.getDamageById(id);
        return ResponseEntity.ok(Response.success("Damage fetched",damageDto, HttpStatus.OK));
    }

    @GetMapping()
    public ResponseEntity<Response<Page<DamageDto>>> getDamages(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {
        Page<DamageDto> damageDtoPage = damageService.getDamages(page,size);
        return ResponseEntity.ok(Response.success("Damages fetched",damageDtoPage, HttpStatus.OK));
    }

    @PostMapping()
    public ResponseEntity<Response<DamageDto>> createDamage(@Validated @RequestBody CreateDamageDto createDamageDto){
        DamageDto damageDto = damageService.createDamage(createDamageDto);
        return ResponseEntity.ok(Response.success("Damage created",damageDto, HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<CarDto>> updateDamage(@PathVariable UUID id, @Validated @RequestBody UpdateDamageDto updateDamageDto){
        damageService.updateDamage(id,updateDamageDto);
        return ResponseEntity.ok(Response.success("Damage updated",null, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteDamage(@PathVariable UUID id){
        damageService.deleteDamage(id);
        return ResponseEntity.ok(Response.success("Damage deleted",null, HttpStatus.OK));
    }
}
