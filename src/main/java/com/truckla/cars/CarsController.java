package com.truckla.cars;

import com.truckla.cars.exceptions.ResourceNotFoundException;
import com.truckla.cars.model.Car;
import com.truckla.cars.repositories.CarsRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cars")
@Api(description = "Manage cars", tags = { "Cars" })
public class CarsController {

    @Autowired
    private CarsRepository carsRepository;

    @GetMapping
    public List<Car> getCars() {
        return carsRepository.findAll();
    }

    @PostMapping
    public Car addCar(@Valid @RequestBody Car car) {
        return carsRepository.save(car);
    }

    @PutMapping
    public Car updateCar(@Validated(Car.Existing.class) @RequestBody Car car) {
        carsRepository.findById(car.getId()).orElseThrow(ResourceNotFoundException::new);
        return carsRepository.save(car);
    }

    @GetMapping(value = "/{id}")
    public Car getCarById(@PathVariable("id") long id) {
        return carsRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @DeleteMapping(value = "/{id}")
    public void removeCarById(@PathVariable("id") long id) {
        carsRepository.deleteById(id);
    }
}
