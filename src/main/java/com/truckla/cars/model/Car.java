package com.truckla.cars.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "CARS")
@SequenceGenerator(name="seq", initialValue=4, allocationSize=100)
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")

    @NotNull(message = "Please provide an id.", groups = Existing.class)
    private Long id;

    @NotNull(message = "Please provide the name of the car manufacturer.")
    String manufacturer;

    @NotNull(message = "Please provide the car model.")
    String model;

    @NotNull(message = "Please provide the build year.")
    @Min(1900)
    @Max(2020)
    int build;

    public Car() {
    }

    public Car(Long id, String manufacturer, String model, int build) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.build = build;
    }

    public interface Existing {
    }

    public Long getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getBuild() {
        return build;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBuild(int build) {
        this.build = build;
    }
}
