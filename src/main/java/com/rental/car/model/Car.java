package com.rental.car.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
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

    private boolean available;
}
