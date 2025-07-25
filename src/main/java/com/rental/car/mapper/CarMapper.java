package com.rental.car.mapper;

import com.rental.car.dto.request.CreateCarDto;
import com.rental.car.dto.response.CarDto;
import com.rental.car.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDto toDto(Car car){
        return new CarDto(
                car.getId(),
                car.getType(),
                car.getBrand(),
                car.getModel(),
                car.getVin(),
                car.getRegistrationNumber(),
                car.getFuelType(),
                car.getYear(),
                car.getPricePerDay(),
                car.isAvailable()
        );
    }

    public Car toEntity(CreateCarDto createCarDto){
        return new Car(
                createCarDto.getType(),
                createCarDto.getBrand(),
                createCarDto.getModel(),
                createCarDto.getVin(),
                createCarDto.getRegistrationNumber(),
                createCarDto.getFuelType(),
                createCarDto.getYear(),
                createCarDto.getPricePerDay()
        );
    }

}
