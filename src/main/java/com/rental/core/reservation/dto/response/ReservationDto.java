package com.rental.core.reservation.dto.response;

import com.rental.core.car.dto.response.SimpleCarDto;
import com.rental.core.reservation.model.ReservationStatus;
import com.rental.user.appuser.dto.response.SimpleUserDto;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class ReservationDto {
    UUID id;
    String reservationNumber;
    ReservationStatus status;
    SimpleUserDto user;
    SimpleCarDto car;
    LocalDate from;
    LocalDate to;
    LocalDate createdAt;
    int reservationDays;
    BigDecimal totalPrice;
}
