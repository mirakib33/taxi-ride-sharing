package com.driver.service;

import com.driver.entity.Driver;
import org.springframework.http.ResponseEntity;

public interface DriverService {

    public ResponseEntity<String> registerDriver(Driver passenger);

}
