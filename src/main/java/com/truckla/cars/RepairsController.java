package com.truckla.cars;

import com.fasterxml.jackson.annotation.JsonView;
import com.truckla.cars.exceptions.ResourceNotFoundException;
import com.truckla.cars.model.Repair;
import com.truckla.cars.model.View;
import com.truckla.cars.repositories.RepairsRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cars")
@Api(description = "Manage repairs", tags = { "Repairs" })
public class RepairsController {

    @Autowired
    private RepairsRepository repairsRepository;

    @GetMapping(value = "/{carId}/repairs")
    @JsonView(View.Summary.class)
    public List<Repair> getRepairsByCarId(@PathVariable("carId") long carId) {
        return repairsRepository.findByCarId(carId);
    }

    @GetMapping(value = "/{carId}/repairs/{repairId}")
    public Repair getRepairById(@PathVariable("carId") long carId, @PathVariable("repairId") long repairId) {
        return repairsRepository.findByIdAndCarId(repairId, carId).orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping(value = "/{carId}/repairs")
    public Repair addRepair(@Valid @RequestBody Repair repair, @PathVariable("carId") long carId) {
        repair.setCarId(carId);
        return repairsRepository.save(repair);
    }

    @PostMapping(value = "/repairs")
    public Repair addRepair(@Valid @RequestBody Repair repair) {
        return repairsRepository.save(repair);
    }
}
