package com.ride.service;

import com.ride.DTO.RideDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface RideService {

    public ResponseEntity<String> rideRequest(RideDTO rideDTO);

    ResponseEntity<?> getRideByPassengerId(String passengerId);

    ResponseEntity<?> getRideByDriverId(String driverId);

    ResponseEntity<String> updateRideStatusByDriver(String rideId, String status);

    ResponseEntity<String> updateRideStatusByPassenger(String rideId, String status);
}
