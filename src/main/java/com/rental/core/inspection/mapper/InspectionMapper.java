package com.rental.core.inspection.mapper;

import com.rental.core.car.mapper.CarMapper;
import com.rental.core.inspection.dto.response.InspectionDto;
import com.rental.core.inspection.model.Inspection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InspectionMapper {
    private final CarMapper carMapper;

    public InspectionDto toDto(Inspection inspection){
        return new InspectionDto(
                inspection.getId(),
                carMapper.toSimpleDto(inspection.getCar()),
                inspection.getStatus(),
                inspection.getInspectionDate(),
                inspection.getNotes()
        );
    }

}
