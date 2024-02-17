package com.billing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "status")
    private String status;

    @Column(name = "requested_on")
    private Date requestedOn;

    @Column(name = "accepted_on")
    private Date acceptedOn;

    @Column(name = "fare")
    private Double fare;

    @Column(name = "passenger_id")
    private String passengerId;

    @Column(name = "driver_id")
    private String driverId;


}
