package com.passenger.service.impl;

import com.passenger.DTO.PassengerDTO;
import com.passenger.constants.PassengerConstants;
import com.passenger.entity.Passenger;
import com.passenger.repository.PassengerRepository;
import com.passenger.service.PassengerService;
import com.passenger.utils.PassengerUtils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<String> registerPassenger(PassengerDTO passengerDTO) {

        try {
            Passenger passenger = dtoToPassenger(passengerDTO);

            String passengerId = UUID.randomUUID().toString();
            passenger.setPassengerId(passengerId);

            passengerRepository.saveAndFlush(passenger);
            log.info("Passenger registered successfully");
            return PassengerUtils.getResponseEntity("Passenger registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error occurred while registering passenger", e);
        }
        return PassengerUtils.getResponseEntity(PassengerConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public Passenger dtoToPassenger(PassengerDTO passengerDTO) {
        return this.modelMapper.map(passengerDTO, Passenger.class);
    }

    public PassengerDTO PassengerToDto(Passenger passenger) {
        return this.modelMapper.map(passenger, PassengerDTO.class);
    }


}
