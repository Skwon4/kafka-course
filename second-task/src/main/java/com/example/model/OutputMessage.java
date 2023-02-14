package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutputMessage {

    public Integer id;
    public Double totalDistance;
    public Double lastTraveledDistance;

    @Override
    public String toString() {
        return "Vehicle " + id + " traveled " + lastTraveledDistance + " km since last signal. " +
                "Total distance - " + totalDistance + " km.";
    }
}
