package com.driver.DTO;

import com.driver.entity.AvailableDriver;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
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

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone cannot be blank")
    @Pattern(regexp = "\\d{11}", message = "Phone number should be 11 digits")
    private String phone;

    @NotBlank(message = "Vehicle type cannot be blank")
    private String vehicleType;

    @NotBlank(message = "Driving license number cannot be blank")
    private String drivingLicenseNumber;

    @NotBlank(message = "City cannot be blank")
    private String city;

    private boolean status;

    private String availableFrom;

}
