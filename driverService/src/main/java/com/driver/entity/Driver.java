package com.driver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "driver")
public class Driver {
    @Id
    @Column(name = "driver_id", nullable = false)
    private String driverId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;

    @Column(name = "driving_license_number", unique = true, nullable = false)
    private String drivingLicenseNumber;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "status")
    private boolean status;

    @Column(name = "available_from")
    private String availableFrom;

}
