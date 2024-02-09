package com.passenger.service;


import com.passenger.DTO.PassengerDTO;
import com.passenger.entity.Passenger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface PassengerService {
    public ResponseEntity<String> registerPassenger(PassengerDTO passengerDTO);

    public ResponseEntity<?> getAvailableDrivers(String availableFrom, String type);

    public ResponseEntity<?> getFareByDistanceAndType(String destination);

    public ResponseEntity<String> rideRequest(String passengerId, String driverId);
}
