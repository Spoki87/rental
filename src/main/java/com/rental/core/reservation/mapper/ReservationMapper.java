package com.rental.core.reservation.mapper;

import com.rental.core.car.mapper.CarMapper;
import com.rental.core.reservation.dto.response.ReservationDto;
import com.rental.core.reservation.model.Reservation;
import com.rental.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationMapper {

    private final CarMapper carMapper;
    private final UserMapper userMapper;

    public ReservationDto toDto(Reservation reservation){
        return new ReservationDto(
                reservation.getId(),
                reservation.getReservationNumber(),
                reservation.getStatus(),
                userMapper.toSimpleDto(reservation.getUser()),
                carMapper.toSimpleDto(reservation.getCar()),
                reservation.getFrom(),
                reservation.getTo(),
                reservation.getCreatedAt(),
                reservation.getReservationDays(),
                reservation.getTotalPrice()
        );
    }
}
