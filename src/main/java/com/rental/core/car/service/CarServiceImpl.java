package com.rental.core.car.service;

import com.rental.core.car.dto.request.CreateCarDto;
import com.rental.core.car.dto.request.UpdateCarDto;
import com.rental.core.car.dto.response.CarDto;
import com.rental.core.car.mapper.CarMapper;
import com.rental.core.car.model.Car;
import com.rental.core.car.repository.CarRepository;
import com.rental.exception.domain.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CarDto getCarById(UUID uuid) {
        Car car = carRepository.findById(uuid)
                .orElseThrow(()->new ResourceNotFoundException(Car.class, uuid));

        return carMapper.toDto(car);
    }

    @Override
    public Page<CarDto> getCars(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Car> carsPage = carRepository.findAll(pageable);

        List<CarDto> dtoList = carsPage.stream()
                .map(carMapper::toDto)
                .toList();

        return new PageImpl<>(dtoList, pageable, carsPage.getTotalElements());
    }


    @Override
    public CarDto createCar(CreateCarDto createCarDto) {
        Car car = new Car(
                createCarDto.getType(),
                createCarDto.getBrand(),
                createCarDto.getModel(),
                createCarDto.getVin(),
                createCarDto.getRegistrationNumber(),
                createCarDto.getFuelType(),
                createCarDto.getYear(),
                createCarDto.getPricePerDay()
        );
        carRepository.save(car);
        return carMapper.toDto(car);
    }

    @Override
    @Transactional
    public void updateCar(UUID uuid, UpdateCarDto updateCarDto) {
        Car car = carRepository.findById(uuid)
                .orElseThrow(()->new ResourceNotFoundException(Car.class, uuid));
        car.updateCarDetails(updateCarDto);
    }

    @Override
    @Transactional
    public void deleteCar(UUID uuid) {
        if (!carRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(Car.class, uuid);
        }
        carRepository.deleteById(uuid);
    }
}
