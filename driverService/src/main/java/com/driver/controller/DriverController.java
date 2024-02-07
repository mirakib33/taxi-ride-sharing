package com.driver.controller;

import com.driver.DTO.DriverDTO;
import com.driver.constants.DriverConstants;
import com.driver.entity.Driver;
import com.driver.entity.VehicleType;
import com.driver.service.DriverService;
import com.driver.utils.DriverUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/{driverId}")
    public ResponseEntity<?> getDriverById(@PathVariable String driverId) {
        try {
            ResponseEntity<?> response = driverService.getDriverById(driverId);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while getting driver by driver id", e);
        }
        return DriverUtils.getResponseEntity(DriverConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerDriver(@Valid @RequestBody DriverDTO driverDTO) {
        try {
            ResponseEntity<String> response = driverService.registerDriver(driverDTO);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while registering driver", e);
        }
        return DriverUtils.getResponseEntity(DriverConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/availableDrivers")
    public ResponseEntity<?> getAvailableDriver(@RequestParam("availableFrom") String availableFrom) {
        try {
            ResponseEntity<?> response = driverService.getAvailableDriver(availableFrom);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while getting available drivers from drivers", e);
        }
        return DriverUtils.getResponseEntity(DriverConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/vehicleTypes")
    public ResponseEntity<List<VehicleType>> getAllVehicleTypes() {
        try {
            ResponseEntity<List<VehicleType>> response = driverService.getAllVehicleTypes();
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
//            return driverService.getAllVehicleTypes();
        } catch (Exception e) {
            log.error("Error occurred while getting all vehicle types", e);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
