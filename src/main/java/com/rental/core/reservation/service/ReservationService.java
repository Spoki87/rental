package com.rental.core.reservation.service;

import com.rental.core.reservation.dto.request.CreateReservationDto;
import com.rental.core.reservation.dto.response.ReservationDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ReservationService {
    ReservationDto getReservationById(UUID id);
    Page<ReservationDto> getReservations(int page, int size);
    Page<ReservationDto> getReservationsByUser(UUID userId, int page, int size);
    ReservationDto createReservation(CreateReservationDto createReservationDto);
    void cancelReservation(UUID id);
    void deleteReservation(UUID id);

}
