package com.truckla.cars.repositories;

import com.truckla.cars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarsRepository extends JpaRepository<Car, Long> {

    Optional<Car> findById(Long id);

}