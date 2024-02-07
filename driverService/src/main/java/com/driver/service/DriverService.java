package com.driver.service;

import com.driver.DTO.DriverDTO;
import com.driver.entity.Driver;
import com.driver.entity.VehicleType;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DriverService {


    public ResponseEntity<?> getDriverById(String driverId);
    public ResponseEntity<String> registerDriver(DriverDTO driverDTO);
    public ResponseEntity<?> getAvailableDriver(String availableFrom);
    public ResponseEntity<List<VehicleType>> getAllVehicleTypes();

}
