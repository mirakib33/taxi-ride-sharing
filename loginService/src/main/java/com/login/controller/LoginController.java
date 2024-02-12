package com.login.controller;

import com.login.constants.LoginConstants;
import com.login.DTO.Login;
import com.login.service.LoginService;
import com.login.utils.LoginUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> getPassengerById(@RequestBody Login login) {
        try {
            ResponseEntity<?> response = loginService.login(login);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while login", e);
        }
        return LoginUtils.getResponseEntity(LoginConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
