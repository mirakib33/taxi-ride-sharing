package com.login.service;

import com.login.DTO.Login;
import org.springframework.http.ResponseEntity;

public interface LoginService {

    public ResponseEntity<?> login(Login login);

}
