package com.rental.core.reservation.model;

import com.rental.core.car.model.Car;
import com.rental.user.appuser.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReservationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "start_date", nullable = false)
    private LocalDate from;

    @Column(name = "end_date", nullable = false)
    private LocalDate to;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @Column(name = "reservation_days")
    private int reservationDays;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDate.now();
        if (this.status == null) {
            this.status = ReservationStatus.PENDING;
        }
    }
}
