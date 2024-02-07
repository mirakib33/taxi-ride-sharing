package com.driver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class VehicleType {

    @Id
    @Column(name = "vehicle_type_id")
    private Long vehicleTypeId;

    @Column(name = "type")
    private String type;

}
