package com.example.carwashwebappbackend.repository;

import com.example.carwashwebappbackend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
