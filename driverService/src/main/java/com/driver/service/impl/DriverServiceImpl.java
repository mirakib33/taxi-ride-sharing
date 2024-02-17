package com.driver.service.impl;

import com.driver.DTO.DriverDTO;
import com.driver.constants.DriverConstants;
import com.driver.entity.Driver;
import com.driver.entity.VehicleType;
import com.driver.repository.DriverRepository;
import com.driver.repository.VehicleTypeRepository;
import com.driver.service.DriverService;
import com.driver.utils.DriverUtils;
import com.driver.utils.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
@Slf4j
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;


    @Override
    public ResponseEntity<?> getDriverById(String driverId) {
        try {
            log.info("Getting driver by driver id");
            Optional<Driver> driver = driverRepository.findById(driverId);
            if(!driver.isPresent()) {
                return new ResponseEntity<>("Driver does not exist with this id", HttpStatus.NOT_FOUND);
            }
            DriverDTO driverDTO = driverToDto(driver.get());
            return new ResponseEntity<>(driverDTO, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while getting driver by driver id", e);
        }
        return DriverUtils.getResponseEntity(DriverConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> registerDriver(DriverDTO driverDTO) {
        try {
            Driver driver = dtoToDriver(driverDTO);

            String driverId = UUID.randomUUID().toString();
            driver.setDriverId(driverId);

            driverRepository.saveAndFlush(driver);
            log.info("Driver registered successfully");
            return DriverUtils.getResponseEntity("Driver registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error occurred while registering driver", e);
        }
        return DriverUtils.getResponseEntity(DriverConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> getAvailableDriver(String availableFrom,  String type) {
        try {
            log.info("Getting available driver");
            List<Driver> availableDrivers = driverRepository.findByStatusAndAvailableFromContainingAndVehicleType(true, availableFrom, type);

//            if (availableDrivers == null || availableDrivers.isEmpty()) {
//                return new ResponseEntity<>("No driver available right now for the specified place", HttpStatus.NOT_FOUND);
//            }

            List<DriverDTO> availableDriverDTOs = availableDrivers.stream()
                    .map(driver -> driverToDto(driver))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(availableDriverDTOs, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while getting available drivers", e);
        }
        return DriverUtils.getResponseEntity(DriverConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<VehicleType>> getAllVehicleTypes() {
        try {
            List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();
            log.info("Getting all vehicle types from vehicleType");
            return new ResponseEntity<>(allVehicleTypes, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while getting all vehicle types from vehicleType", e);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateDriverStatusById(String driverId, Boolean status) {
        try{
            Driver driver = driverRepository.findById(driverId)
                    .orElseThrow(() -> new ResourceNotFoundException("Ride not found with id: " + driverId));

            driver.setStatus(status);
            driverRepository.saveAndFlush(driver);
            log.info("Ride status updated successfully by passenger");
            return DriverUtils.getResponseEntity("Ride cancelled successfully", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while updating ride status by passenger", e);
        }
        return DriverUtils.getResponseEntity(DriverConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public Driver dtoToDriver(DriverDTO driverDTO) {
        return this.modelMapper.map(driverDTO, Driver.class);
    }

    public DriverDTO driverToDto(Driver driver) {
        return this.modelMapper.map(driver, DriverDTO.class);
    }

}
