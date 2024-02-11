package com.passenger.controller;

import com.passenger.DTO.PassengerDTO;
import com.passenger.clients.DriverClient;
import com.passenger.constants.PassengerConstants;
import com.passenger.DTO.VehicleTypeDTO;
import com.passenger.service.PassengerService;
import com.passenger.utils.PassengerUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private RestTemplate restTemplate;

    private final DriverClient driverClient;

    @Autowired
    public PassengerController(DriverClient driverClient) {
        this.driverClient = driverClient;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerPassenger(@Valid @RequestBody PassengerDTO passengerDTO) {
        try {
            ResponseEntity<String> response = passengerService.registerPassenger(passengerDTO);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while registering passenger", e);
        }
        return PassengerUtils.getResponseEntity(PassengerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<?> getPassengerById(@PathVariable String passengerId) {
        try {
            ResponseEntity<?> response = passengerService.getPassengerById(passengerId);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while getting passenger by passenger id", e);
        }
        return PassengerUtils.getResponseEntity(PassengerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/availableDrivers")
    public ResponseEntity<?> getAvailableDrivers(@RequestParam("availableFrom") String availableFrom, @RequestParam("type") String type) {
        try {
            ResponseEntity<?> response = passengerService.getAvailableDrivers(availableFrom, type);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while getting available drivers from driver service", e);
        }
        return PassengerUtils.getResponseEntity(PassengerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @GetMapping(path = "/vehicleTypes")
//    public ResponseEntity<List<VehicleType>> getAllVehicleTypes() {
//        try {
//            ResponseEntity<List<VehicleType>> response = restTemplate.exchange(
//                    PassengerConstants.DRIVER_SERVICE_URL + "vehicleTypes",
//                    HttpMethod.GET,
//                    null, // No request body
//                    new ParameterizedTypeReference<List<VehicleType>>() {}
//            );
//            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
//        } catch (Exception e) {
//            log.error("Error occurred while getting all vehicle types", e);
//        }
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @GetMapping("/fare")
    public ResponseEntity<?> getFareByDistanceAndType(@RequestParam("destination") String destination) {
        try {
            ResponseEntity<?> response = passengerService.getFareByDistanceAndType(destination);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while getting fare", e);
        }
        return PassengerUtils.getResponseEntity(PassengerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/rideRequest")
    public ResponseEntity<String> rideRequest(@RequestParam("passengerId") String passengerId, @RequestParam("driverId") String driverId) {
        try {
            ResponseEntity<String> response = passengerService.rideRequest(passengerId, driverId);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while requesting for ride", e);
        }
        return PassengerUtils.getResponseEntity(PassengerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/cancelRide/{rideId}")
    public ResponseEntity<?> updateRideStatusByPassenger(@PathVariable String rideId, @RequestParam("status") String status) {
        try{
            String url = PassengerConstants.RIDE_SERVICE_URL + "update/passenger/" + rideId + "?status=" + status;
            ResponseEntity<String>  response = restTemplate.getForEntity(url, String.class);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while updating ride status by driver", e);
        }
        return PassengerUtils.getResponseEntity(PassengerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/vehicleTypes")
    public ResponseEntity<List<VehicleTypeDTO>> getAllVehicleTypes() {
        try {
            ResponseEntity<List<VehicleTypeDTO>> response = driverClient.getAllVehicleTypes();
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while getting all vehicle types", e);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
