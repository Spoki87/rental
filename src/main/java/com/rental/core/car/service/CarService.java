package com.rental.core.car.service;

import com.rental.core.car.dto.request.CreateCarDto;
import com.rental.core.car.dto.request.UpdateCarDto;
import com.rental.core.car.dto.response.CarDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface CarService {
    CarDto getCarById(UUID uuid);
    Page<CarDto> getCars(int page, int size);
    CarDto createCar(CreateCarDto createCarDto);
    void updateCar(UUID uuid, UpdateCarDto updateCarDto);
    void deleteCar(UUID uuid);
}
