package com.rental.car.dto.request;

import com.rental.car.model.CarType;
import com.rental.car.model.FuelType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarDto {
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
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    BigDecimal pricePerDay;
}
