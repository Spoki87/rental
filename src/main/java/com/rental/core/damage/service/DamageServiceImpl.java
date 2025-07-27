package com.rental.core.damage.service;

import com.rental.core.car.dto.response.CarDto;
import com.rental.core.car.model.Car;
import com.rental.core.car.repository.CarRepository;
import com.rental.core.damage.dto.request.CreateDamageDto;
import com.rental.core.damage.dto.request.UpdateDamageDto;
import com.rental.core.damage.dto.response.DamageDto;
import com.rental.core.damage.mapper.DamageMapper;
import com.rental.core.damage.model.Damage;
import com.rental.core.damage.repository.DamageRepository;
import com.rental.exception.domain.ResourceNotFoundException;
import com.rental.user.appuser.model.User;
import com.rental.user.appuser.repository.UserRepository;
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
public class DamageServiceImpl implements DamageService{

    private final DamageRepository damageRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final DamageMapper damageMapper;

    @Override
    public DamageDto getDamageById(UUID id) {
        Damage damage = damageRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(Damage.class, id));

        return damageMapper.toDto(damage);
    }

    @Override
    public Page<DamageDto> getDamages(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Damage> damagePage = damageRepository.findAll(pageable);

        List<DamageDto> dtoList = damagePage.stream()
                .map(damageMapper::toDto)
                .toList();

        return new PageImpl<>(dtoList,pageable,damagePage.getTotalElements());
    }

    @Override
    public DamageDto createDamage(CreateDamageDto createDamageDto) {
        Car car = carRepository.findById(createDamageDto.getCarId())
                .orElseThrow(()->new ResourceNotFoundException(Car.class, createDamageDto.getCarId()));

        User user = null;
        if (createDamageDto.getUserId() != null) {
            user = userRepository.findById(createDamageDto.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException(User.class, createDamageDto.getUserId()));
        }

        Damage damage = new Damage(
                user,
                car,
                createDamageDto.getDamageDate(),
                createDamageDto.getDescription(),
                createDamageDto.getRepairCost()
        );

        damageRepository.save(damage);

        return damageMapper.toDto(damage);
    }

    @Override
    @Transactional
    public void updateDamage(UUID id, UpdateDamageDto updateDamageDto) {
        Car car = carRepository.findById(updateDamageDto.getCarId())
                .orElseThrow(()->new ResourceNotFoundException(Car.class, updateDamageDto.getCarId()));

        User user = null;
        if (updateDamageDto.getUserId() != null) {
            user = userRepository.findById(updateDamageDto.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException(User.class, updateDamageDto.getUserId()));
        }

        Damage damage = damageRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(Damage.class, id));

        damage.updateDamageDetails(updateDamageDto,user,car);
    }

    @Override
    @Transactional
    public void deleteDamage(UUID id) {
        if(!damageRepository.existsById(id)){
            throw new ResourceNotFoundException(Damage.class, id);
        }
        damageRepository.deleteById(id);
    }
}
