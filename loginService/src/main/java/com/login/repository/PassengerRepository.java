package com.login.repository;

import com.login.DTO.PassengerDTO;
import com.login.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<PassengerDTO, String> {

    PassengerDTO findByEmail(String email);

}
