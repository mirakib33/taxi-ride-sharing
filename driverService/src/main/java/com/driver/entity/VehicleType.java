package com.driver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicle_type")
public class VehicleType {

    @Id
    @Column(name = "vehicle_type_id")
    private Long vehicleTypeId;

    @Column(name = "type")
    private String type;

    @Column(name = "seats")
    private String seats;

}
