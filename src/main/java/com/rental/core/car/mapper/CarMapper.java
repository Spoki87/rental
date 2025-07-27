package com.rental.core.car.mapper;

import com.rental.core.car.dto.response.CarDto;
import com.rental.core.car.dto.response.SimpleCarDto;
import com.rental.core.car.model.Car;
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

    public SimpleCarDto toSimpleDto(Car car){
        return new SimpleCarDto(
                car.getId(),
                car.getBrand() + " " + car.getModel()
        );
    }

}
