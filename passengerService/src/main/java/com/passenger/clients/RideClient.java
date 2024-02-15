package com.passenger.clients;

import com.passenger.DTO.RideDTO;
import com.passenger.constants.PassengerConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ride-service", url = PassengerConstants.RIDE_SERVICE_URL)
public interface RideClient {

    @PostMapping("/rideRequest")
    public ResponseEntity<String> rideRequest(@RequestBody RideDTO rideDTO);

}
