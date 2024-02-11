package com.login.service.impl;

import com.login.DTO.DriverDTO;
import com.login.DTO.PassengerDTO;
import com.login.constants.LoginConstants;
import com.login.entity.Login;
import com.login.repository.DriverRepository;
import com.login.repository.PassengerRepository;
import com.login.service.LoginService;
import com.login.utils.LoginUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public ResponseEntity<?> login(Login login) {
        try {
            if("Passenger".equalsIgnoreCase(login.getUserType())) {
                PassengerDTO user = passengerRepository.findByEmail(login.getEmail());
                if(user == null) {
                    return new ResponseEntity<>("User not found with this email", HttpStatus.NOT_FOUND);
                } else {
                    user.setUserType(login.getUserType());
                    return new ResponseEntity<>(user, HttpStatus.OK);
                }
            } else if ("Driver".equalsIgnoreCase(login.getUserType())) {
                DriverDTO user = driverRepository.findByEmail(login.getEmail());
                if(user == null) {
                    return new ResponseEntity<>("User not found with this email", HttpStatus.NOT_FOUND);
                } else {
                    user.setUserType(login.getUserType());
                    return new ResponseEntity<>(user, HttpStatus.OK);
                }
            }
        } catch (Exception e) {
            log.error("Error occurred while login", e);
        }
        return LoginUtils.getResponseEntity(LoginConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
