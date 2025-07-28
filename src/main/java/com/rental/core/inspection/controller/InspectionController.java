package com.rental.core.inspection.controller;

import com.rental.core.inspection.dto.request.CreateInspectionDto;
import com.rental.core.inspection.dto.request.UpdateInspectionDto;
import com.rental.core.inspection.dto.response.InspectionDto;
import com.rental.core.inspection.service.InspectionService;
import com.rental.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/inspections")
@RequiredArgsConstructor
@Validated
public class InspectionController {
    private final InspectionService inspectionService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<InspectionDto>> getDamageById(@PathVariable UUID id){
        InspectionDto inspectionDto = inspectionService.getInspectionById(id);
        return ResponseEntity.ok(Response.success("Inspection fetched",inspectionDto, HttpStatus.OK));
    }

    @GetMapping()
    public ResponseEntity<Response<Page<InspectionDto>>> getDamages(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {
        Page<InspectionDto> inspectionDtoPage = inspectionService.getInspections(page,size);
        return ResponseEntity.ok(Response.success("Inspections fetched",inspectionDtoPage, HttpStatus.OK));
    }

    @PostMapping()
    public ResponseEntity<Response<InspectionDto>> createDamage(@Validated @RequestBody CreateInspectionDto createInspectionDto){
        InspectionDto inspectionDto = inspectionService.createInspection(createInspectionDto);
        return ResponseEntity.ok(Response.success("Inspection created",inspectionDto, HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<InspectionDto>> updateDamage(@PathVariable UUID id, @Validated @RequestBody UpdateInspectionDto updateInspectionDto){
        inspectionService.updateInspection(id,updateInspectionDto);
        return ResponseEntity.ok(Response.success("Inspection updated",null, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteDamage(@PathVariable UUID id){
        inspectionService.deleteInspection(id);
        return ResponseEntity.ok(Response.success("Inspection deleted",null, HttpStatus.OK));
    }
}
