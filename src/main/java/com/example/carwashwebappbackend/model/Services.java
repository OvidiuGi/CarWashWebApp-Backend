package com.example.carwashwebappbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="services")
@Data
public class Services {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="price")
    private int price;

    @Column(name="description")
    private int description;

    @ManyToMany(mappedBy = "services")
    private Set<CarWash> carWashes;

    public void addCarWash(CarWash carWash) {
        this.carWashes.add(carWash);
        carWash.getServices().add(this);
    }

    public void removeCarWash(int carWashId) {
        CarWash carWash = this.carWashes.stream().filter(c -> c.getId() == carWashId).findFirst().orElse(null);
        if (carWash != null) {
            this.carWashes.remove(carWash);
            carWash.getServices().remove(this);
        }
    }
}
