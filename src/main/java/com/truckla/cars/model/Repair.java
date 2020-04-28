package com.truckla.cars.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "REPAIRS")
@SequenceGenerator(name="seq2", initialValue=12, allocationSize=100)
public class Repair {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq2")
    @JsonView(View.Summary.class)
    private Long id;

    private Long carId;

    @JsonView(View.Summary.class)
    private Date repair_date;

    private String description;

    public Repair() {
    }

    public Repair(Long id, Long carId, Date repair_date, String description) {
        this.id = id;
        this.carId = carId;
        this.repair_date = repair_date;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Date getRepair_date() {
        return repair_date;
    }

    public void setRepair_date(Date repair_date) {
        this.repair_date = repair_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
