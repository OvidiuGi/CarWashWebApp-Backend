package com.example.carwashwebappbackend.dao;

import com.example.carwashwebappbackend.entity.Appointments;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentsRepository extends CrudRepository<Appointments, Integer> {
}
