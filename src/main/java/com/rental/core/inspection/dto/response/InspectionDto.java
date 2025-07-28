package com.rental.core.inspection.dto.response;

import com.rental.core.car.dto.response.SimpleCarDto;
import com.rental.core.inspection.model.InspectionStatus;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class InspectionDto {
    UUID id;
    SimpleCarDto car;
    InspectionStatus status;
    LocalDate inspectionDate;
    String notes;
}
