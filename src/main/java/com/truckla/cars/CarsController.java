package com.truckla.cars;

import com.truckla.cars.exceptions.ResourceNotFoundException;
import com.truckla.cars.model.Car;
import com.truckla.cars.model.Repair;
import com.truckla.cars.repositories.CarsRepository;
import com.truckla.cars.repositories.RepairsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cars")
public class CarsController {

    @Autowired
    private CarsRepository repository;

    @Autowired
    private RepairsRepository repairsRepository;

    @GetMapping
    public List<Car> getCars() {
        return repository.findAll();
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return repository.save(car);
    }

    @GetMapping(value = "/{id}")
    public Car getCarById(@PathVariable("id") long id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @DeleteMapping(value = "/{id}")
    public void removeCarById(@PathVariable("id") long id) {
        repository.deleteById(id);
    }

    @GetMapping(value = "/{carId}/repairs")
    public List<Repair> getRepairsByCarId(@PathVariable("carId") long carId) {
        return repairsRepository.findByCarId(carId);
    }

    @GetMapping(value = "/{carId}/repairs/{repairId}")
    public Repair getRepairById(@PathVariable("carId") long carId, @PathVariable("repairId") long repairId) {
        return repairsRepository.findById(repairId).orElseThrow(ResourceNotFoundException::new);
    }
}
