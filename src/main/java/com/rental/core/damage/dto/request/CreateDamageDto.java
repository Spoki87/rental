package com.rental.core.damage.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDamageDto {

    private UUID userId;

    @NotNull(message = "Car id is required")
    private UUID carId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate damageDate;

    @Size(max = 3000, message = "Description can be at most 3000 characters long")
    private String description;

    @PositiveOrZero(message = "Repair cost must be zero or positive")
    private BigDecimal repairCost;
}
