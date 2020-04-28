package com.truckla.cars;

import com.truckla.cars.model.FleetAge;
import com.truckla.cars.services.FleetStatisticsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cars/statistics")
@Api(description = "Statistics about the car fleet", tags = { "Statistics" })
public class StatisticsController {

    @Autowired
    FleetStatisticsService service;

    @GetMapping(value = "/average-age")
    public FleetAge getCarById() {
        return service.getAverageFleetAge();
    }
}
