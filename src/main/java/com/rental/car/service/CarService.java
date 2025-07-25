package com.rental.car.service;

import com.rental.car.dto.request.CreateCarDto;
import com.rental.car.dto.request.UpdateCarDto;
import com.rental.car.dto.response.CarDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.UUID;

public interface CarService {
    CarDto getCarById(UUID uuid);
    Page<CarDto> getCars(Pageable pageable);
    CarDto createCar(CreateCarDto createCarDto);
    void updateCar(UUID uuid, UpdateCarDto updateCarDto);
    void deleteCar(UUID uuid);
}
