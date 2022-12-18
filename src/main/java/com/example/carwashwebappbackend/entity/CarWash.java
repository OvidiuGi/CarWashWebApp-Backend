package com.example.carwashwebappbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="carwash")
@Data
public class CarWash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="address")
    private String address;

    @Column(name="name")
    private String name;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="owner_id")
    @JsonIgnore
    @JsonManagedReference
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "carwashservices",
            joinColumns = @JoinColumn(name = "carwash_id"),
            inverseJoinColumns = @JoinColumn(name = "services_id")
    )
    @JsonIgnore
    private Set<Services> services = new HashSet<>();
}
