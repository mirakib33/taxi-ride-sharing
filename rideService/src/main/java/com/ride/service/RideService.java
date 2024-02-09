package com.ride.service;

import com.ride.DTO.RideDTO;
import org.springframework.http.ResponseEntity;

public interface RideService {

    public ResponseEntity<String> rideRequest(RideDTO rideDTO);

    ResponseEntity<?> getRideByPassengerId(String passengerId);

    ResponseEntity<?> getRideByDriverId(String driverId);

    ResponseEntity<String> updateRideStatusByDriver(String rideId, RideDTO rideDTO);

    ResponseEntity<String> updateRideStatusByPassenger(String rideId, RideDTO rideDTO);
}
