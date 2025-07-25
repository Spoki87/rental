package com.rental.car.model;

import com.rental.car.dto.request.UpdateCarDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private CarType type;

    private String brand;

    private String model;

    private String vin;

    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private int year;

    private BigDecimal pricePerDay;

    private boolean isAvailable;

    public Car(CarType type, String brand, String model, String vin, String registrationNumber, FuelType fuelType, int year, BigDecimal pricePerDay) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.vin = vin;
        this.registrationNumber = registrationNumber;
        this.fuelType = fuelType;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.isAvailable = false;
    }

    public void updateCarDetails(UpdateCarDto updateCarDto){
        this.type = updateCarDto.getType();
        this.brand = updateCarDto.getBrand();
        this.model = updateCarDto.getModel();
        this.vin = updateCarDto.getVin();
        this.registrationNumber = updateCarDto.getRegistrationNumber();
        this.fuelType = updateCarDto.getFuelType();
        this.year = updateCarDto.getYear();
        this.pricePerDay = updateCarDto.getPricePerDay();
        this.isAvailable = updateCarDto.isAvailable();
    }
}
