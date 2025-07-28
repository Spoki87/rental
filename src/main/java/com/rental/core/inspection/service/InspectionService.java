package com.rental.core.inspection.service;

import com.rental.core.inspection.dto.request.CreateInspectionDto;
import com.rental.core.inspection.dto.request.UpdateInspectionDto;
import com.rental.core.inspection.dto.response.InspectionDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface InspectionService {
    InspectionDto getInspectionById(UUID id);
    Page<InspectionDto> getInspections(int page, int size);
    InspectionDto createInspection(CreateInspectionDto createInspectionDto);
    void updateInspection(UUID id, UpdateInspectionDto updateInspectionDto);
    void deleteInspection(UUID id);
}
