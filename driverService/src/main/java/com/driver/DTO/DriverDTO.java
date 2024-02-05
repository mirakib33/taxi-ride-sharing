package com.driver.DTO;

import com.driver.entity.AvailableDriver;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String vehicleType;
    private String drivingLicenseNumber;
    private double rating;
    private boolean availabilityStatus;
    private AvailableDriverDTO availableDriver;

}
