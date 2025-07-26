package com.rental.core.car.controller;

import com.rental.core.car.dto.request.CreateCarDto;
import com.rental.core.car.dto.request.UpdateCarDto;
import com.rental.core.car.dto.response.CarDto;
import com.rental.core.car.service.CarService;
import com.rental.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
@Validated
public class CarController {
    private final CarService carService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<CarDto>> getCarById(@PathVariable UUID id){
        CarDto carDto = carService.getCarById(id);
        return ResponseEntity.ok(Response.success("Car fetched",carDto, HttpStatus.OK));
    }

    @GetMapping()
    public ResponseEntity<Response<Page<CarDto>>> getCars(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {
        Page<CarDto> carDtoPage = carService.getCars(page,size);
        return ResponseEntity.ok(Response.success("Cars fetched",carDtoPage, HttpStatus.OK));
    }

    @PostMapping()
    public ResponseEntity<Response<CarDto>> createCar(@Validated @RequestBody CreateCarDto createCarDto){
        CarDto carDto = carService.createCar(createCarDto);
        return ResponseEntity.ok(Response.success("Car created",carDto, HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<CarDto>> updateCar(@PathVariable UUID id, @Validated @RequestBody UpdateCarDto updateCarDto){
        carService.updateCar(id,updateCarDto);
        return ResponseEntity.ok(Response.success("Car updated",null, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteCar(@PathVariable UUID id){
        carService.deleteCar(id);
        return ResponseEntity.ok(Response.success("Car deleted",null, HttpStatus.OK));
    }

}
