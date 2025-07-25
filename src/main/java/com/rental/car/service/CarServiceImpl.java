package com.rental.car.service;

import com.rental.car.dto.request.CreateCarDto;
import com.rental.car.dto.request.UpdateCarDto;
import com.rental.car.dto.response.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{
    @Override
    public CarDto getCarById(UUID uuid) {
        return null;
    }

    @Override
    public Page<CarDto> getCars(Pageable pageable) {
        return null;
    }

    @Override
    public CarDto createCar(CreateCarDto createCarDto) {
        return null;
    }

    @Override
    public void updateCar(UUID uuid, UpdateCarDto updateCarDto) {

    }

    @Override
    public void deleteCar(UUID uuid) {

    }
}
