package com.rental.core.inspection.model;

import com.rental.core.car.model.Car;
import com.rental.core.inspection.dto.request.UpdateInspectionDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "inspection")
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private InspectionStatus status;

    @Column(name = "inspection_date", nullable = false)
    private LocalDate inspectionDate;

    @Column(name = "notes", length = 3000)
    private String notes;

    public Inspection(Car car, InspectionStatus status, LocalDate inspectionDate, String notes) {
        this.car = car;
        this.status = status;
        this.inspectionDate = inspectionDate;
        this.notes = notes;
    }

    public void updateInspectionDetails(UpdateInspectionDto updateInspectionDto, Car car){
        this.car = car;
        this.status = updateInspectionDto.getStatus();
        this.inspectionDate = updateInspectionDto.getInspectionDate();
        this.notes = updateInspectionDto.getNotes();
        if(notes == null){
            this.notes = "";
        }
    }
}
