package com.rental.core.damage.repository;

import com.rental.core.damage.model.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DamageRepository extends JpaRepository<Damage, UUID> {
}
