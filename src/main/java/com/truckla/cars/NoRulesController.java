package com.truckla.cars;

import com.truckla.cars.exceptions.ResourceNotFoundException;
import com.truckla.cars.model.Car;
import com.truckla.cars.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("bad-practices/cars")
@ApiIgnore
public class NoRulesController {
    @Autowired
    private CarsRepository carsRepository;

    @GetMapping(value = "/{id}")
    public void removeCarById(@PathVariable("id") long id) {
        carsRepository.deleteById(id);
    }

    @PostMapping(value = "/{id}")
    public Car getCarById(@PathVariable("id") long id) {
        return carsRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
