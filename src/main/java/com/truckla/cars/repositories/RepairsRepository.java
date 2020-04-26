package com.truckla.cars.repositories;

import com.truckla.cars.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepairsRepository extends JpaRepository<Repair, Long> {

    List<Repair> findByCarId(long carId);

    Optional<Repair> findByIdAndCarId(long id, long carId);
}