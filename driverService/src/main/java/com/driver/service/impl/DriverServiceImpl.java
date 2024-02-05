package com.driver.service.impl;

import com.driver.constants.DriverConstants;
import com.driver.entity.Driver;
import com.driver.repository.DriverRepository;
import com.driver.service.DriverService;
import com.driver.utils.DriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public ResponseEntity<String> registerDriver(Driver driver) {
        try {
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
}
