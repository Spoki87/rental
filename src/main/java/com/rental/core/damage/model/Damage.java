package com.rental.core.damage.model;

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
@Table(name = "damage")
public class Damage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "damage_date", nullable = false)
    private LocalDate damageDate;

    @Column(name = "description",length = 3000)
    private String description;

    @Column(name = "repair_cost")
    private BigDecimal repairCost;
}
