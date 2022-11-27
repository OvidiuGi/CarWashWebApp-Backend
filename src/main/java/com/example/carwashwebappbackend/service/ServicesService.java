package com.example.carwashwebappbackend.service;

import com.example.carwashwebappbackend.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;
}
