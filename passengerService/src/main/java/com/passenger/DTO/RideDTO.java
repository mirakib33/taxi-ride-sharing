package com.passenger.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RideDTO {

    private String rideId;
    private String startFrom;
    private String destination;
    private Date startTime;
    private Date endTime;
    private String status;
    private Date requestedOn;
    private Date acceptedOn;
    private Double fare;
    private String passengerId;
    private String driverId;

}
