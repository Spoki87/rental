package com.rental.core.car.model;

import com.rental.core.car.dto.request.UpdateCarDto;
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
    @Column(name = "type", nullable = false)
    private CarType type;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "vin", nullable = false)
    private String vin;

    @Column(name = "registration_number", nullable = false)
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", nullable = false)
    private FuelType fuelType;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "price_per_day", nullable = false)
    private BigDecimal pricePerDay;

    @Column(name = "is_available", nullable = false)
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
