package com.example.carwashwebappbackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="appointments")
@Data
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="start_time")
    private LocalDateTime startTime;

    @Column(name="end_time")
    private LocalDateTime endTime;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="customer_id")
    private User customer;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="carwash_id")
    private CarWash carWash;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="service_id")
    private Services service;
}
