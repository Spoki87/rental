package com.rental.car.dto.request;

import com.rental.car.model.CarType;
import com.rental.car.model.FuelType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarDto {
    @NotNull(message = "Car type is required")
    CarType type;

    @NotBlank(message = "Brand is required")
    String brand;

    @NotBlank(message = "Model is required")
    String model;

    @NotBlank(message = "VIN is required")
    String vin;

    @NotBlank(message = "Registration number is required")
    String registrationNumber;

    @NotNull(message = "Fuel type is required")
    FuelType fuelType;

    @NotBlank(message = "Year is required")
    int year;

    @NotNull(message = "Price per day is required")
    BigDecimal pricePerDay;
}
