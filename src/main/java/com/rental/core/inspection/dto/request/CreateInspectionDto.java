package com.rental.core.inspection.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rental.core.inspection.model.InspectionStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInspectionDto {

    @NotNull(message = "Car id is required")
    private UUID carId;

    @NotNull(message = "Status is required")
    private InspectionStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "Inspection date is required")
    private LocalDate inspectionDate;

    @Size(max = 3000, message = "Description can be at most 3000 characters long")
    private String notes;
}
