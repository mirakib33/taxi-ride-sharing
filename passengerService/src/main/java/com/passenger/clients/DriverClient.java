package com.passenger.clients;

import com.passenger.constants.PassengerConstants;
import com.passenger.DTO.VehicleTypeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "driver-service", url = PassengerConstants.DRIVER_SERVICE_URL)
public interface DriverClient {

    @GetMapping(path = "/vehicleTypes")
    public ResponseEntity<List<VehicleTypeDTO>> getAllVehicleTypes();

    @GetMapping("/availableDrivers")
    public ResponseEntity<?> getAvailableDriver(@RequestParam("availableFrom") String availableFrom, @RequestParam("type") String type);

}
