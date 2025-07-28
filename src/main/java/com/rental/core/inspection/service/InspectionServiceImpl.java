package com.rental.core.inspection.service;

import com.rental.core.car.model.Car;
import com.rental.core.car.repository.CarRepository;
import com.rental.core.inspection.dto.request.CreateInspectionDto;
import com.rental.core.inspection.dto.request.UpdateInspectionDto;
import com.rental.core.inspection.dto.response.InspectionDto;
import com.rental.core.inspection.mapper.InspectionMapper;
import com.rental.core.inspection.model.Inspection;
import com.rental.core.inspection.repository.InspectionRepository;
import com.rental.exception.domain.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InspectionServiceImpl implements InspectionService{

    private final InspectionRepository inspectionRepository;
    private final CarRepository carRepository;
    private final InspectionMapper inspectionMapper;

    @Override
    public InspectionDto getInspectionById(UUID id) {
        Inspection inspection = inspectionRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(Inspection.class, id));

        return inspectionMapper.toDto(inspection);
    }

    @Override
    public Page<InspectionDto> getInspections(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Inspection> inspectionPage = inspectionRepository.findAll(pageable);

        List<InspectionDto> dtoList = inspectionPage.stream()
                .map(inspectionMapper::toDto)
                .toList();

        return new PageImpl<>(dtoList,pageable,inspectionPage.getTotalElements());
    }

    @Override
    public InspectionDto createInspection(CreateInspectionDto createInspectionDto) {
        Car car = carRepository.findById(createInspectionDto.getCarId())
                .orElseThrow(()->new ResourceNotFoundException(Car.class, createInspectionDto.getCarId()));

        Inspection inspection = new Inspection(
                car,
                createInspectionDto.getStatus(),
                createInspectionDto.getInspectionDate(),
                createInspectionDto.getNotes()
        );
        inspectionRepository.save(inspection);

        return inspectionMapper.toDto(inspection);
    }

    @Override
    @Transactional
    public void updateInspection(UUID id, UpdateInspectionDto updateInspectionDto) {
        Car car = carRepository.findById(updateInspectionDto.getCarId())
                .orElseThrow(()->new ResourceNotFoundException(Car.class, updateInspectionDto.getCarId()));

        Inspection inspection = inspectionRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(Inspection.class, id));

        inspection.updateInspectionDetails(updateInspectionDto,car);
    }

    @Override
    public void deleteInspection(UUID id) {
        if(!inspectionRepository.existsById(id)){
            throw new ResourceNotFoundException(Inspection.class, id);
        }
        inspectionRepository.deleteById(id);
    }
}
