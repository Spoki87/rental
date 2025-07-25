package com.rental.car.dto.response;

import com.rental.car.model.CarType;
import com.rental.car.model.FuelType;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class CarDto {
    UUID id;
    CarType type;
    String brand;
    String model;
    String vin;
    String registrationNumber;
    FuelType fuelType;
    int year;
    BigDecimal pricePerDay;
    boolean available;
}
