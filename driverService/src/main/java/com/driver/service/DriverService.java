package com.driver.service;

import com.driver.DTO.DriverDTO;
import com.driver.entity.Driver;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DriverService {

    public ResponseEntity<String> registerDriver(DriverDTO driverDTO);
    public ResponseEntity<List<DriverDTO>> getAvailableDriver(String availableFrom);

}
