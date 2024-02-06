package com.driver.service.impl;

import com.driver.DTO.DriverDTO;
import com.driver.constants.DriverConstants;
import com.driver.entity.Driver;
import com.driver.repository.DriverRepository;
import com.driver.service.DriverService;
import com.driver.utils.DriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<String> registerDriver(DriverDTO driverDTO) {
        try {
            // Map DriverDTO to Driver entity using ModelMapper
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
    public ResponseEntity<List<DriverDTO>> getAvailableDriver(String availableFrom) {
        try {
            List<Driver> availableDrivers = driverRepository.findByStatusAndAvailableFromContaining(availableFrom);
            log.info("Getting available driver");

            List<DriverDTO> availableDriverDTOs = availableDrivers.stream()
                    .map(driver -> driverToDto(driver))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(availableDriverDTOs, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while registering driver", e);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public Driver dtoToDriver(DriverDTO driverDTO) {
        return this.modelMapper.map(driverDTO, Driver.class);
    }

    public DriverDTO driverToDto(Driver driver) {
        return this.modelMapper.map(driver, DriverDTO.class);
    }

}
