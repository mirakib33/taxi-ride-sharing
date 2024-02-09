package com.ride.controller;

import com.ride.DTO.RideDTO;
import com.ride.constants.RideConstants;
import com.ride.service.RideService;
import com.ride.utils.RideUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping(path = "/api/ride")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/rideRequest")
    public ResponseEntity<String> rideRequest(@RequestBody RideDTO rideDTO) {
        try {
            ResponseEntity<String> response = rideService.rideRequest(rideDTO);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while requesting for ride", e);
        }
        return RideUtils.getResponseEntity(RideConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<?> getRideByPassengerId(@PathVariable String passengerId) {
        try {
            ResponseEntity<?> response = rideService.getRideByPassengerId(passengerId);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while getting ride by passenger id", e);
        }
        return RideUtils.getResponseEntity(RideConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<?> getRideByDriverId(@PathVariable String driverId) {
        try {
            ResponseEntity<?> response = rideService.getRideByDriverId(driverId);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while getting driver by driver id", e);
        }
        return RideUtils.getResponseEntity(RideConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update/driver/{rideId}")
    public ResponseEntity<?> updateRideStatusByDriver(@PathVariable String rideId, @RequestBody RideDTO rideDTO) {
        try{
            ResponseEntity<String> response = rideService.updateRideStatusByDriver(rideId, rideDTO);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while updating ride status by driver", e);
        }
        return RideUtils.getResponseEntity(RideConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update/passenger/{rideId}")
    public ResponseEntity<?> updateRideStatusByPassenger(@PathVariable String rideId, @RequestBody RideDTO rideDTO) {
        try{
            ResponseEntity<String> response = rideService.updateRideStatusByPassenger(rideId, rideDTO);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while updating ride status by passenger", e);
        }
        return RideUtils.getResponseEntity(RideConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
