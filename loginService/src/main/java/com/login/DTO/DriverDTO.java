package com.login.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    private String driverId;
    private String name;
    private String email;
    private String phone;
    private String vehicleType;
    private String drivingLicenseNumber;
    private String city;
    private boolean status;
    private String availableFrom;
    private String userType;

}
