package com.passenger.entity;

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
@Table(name = "ride")
public class Ride {

    @Id
    @Column(name = "ride_id")
    private String rideId;

    @Column(name = "start_from")
    private String startFrom;

    @Column(name = "destination")
    private String destination;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "passenger_id")
    private String drivingLicenseNumber;

    @Column(name = "driver_id")
    private String city;

    @Column(name = "request_status")
    private String requestStatus;

}
