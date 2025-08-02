package com.rental.core.reservation.service;

import com.rental.core.car.repository.CarRepository;
import com.rental.core.reservation.dto.request.CreateReservationDto;
import com.rental.core.reservation.dto.response.ReservationDto;
import com.rental.core.reservation.mapper.ReservationMapper;
import com.rental.core.reservation.model.Reservation;
import com.rental.core.reservation.repository.ReservationRepository;
import com.rental.exception.domain.ResourceNotFoundException;
import com.rental.user.appuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final ReservationMapper reservationMapper;

    @Override
    public ReservationDto getReservationById(UUID id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(Reservation.class,id));

        return reservationMapper.toDto(reservation);
    }

    @Override
    public Page<ReservationDto> getReservations(int page, int size) {
        return null;
    }

    @Override
    public Page<ReservationDto> getReservationsByUser(UUID userId, int page, int size) {
        return null;
    }

    @Override
    public ReservationDto createReservation(CreateReservationDto createReservationDto) {
        return null;
    }

    @Override
    public void cancelReservation(UUID id) {

    }

    @Override
    public void deleteReservation(UUID id) {

    }
}
