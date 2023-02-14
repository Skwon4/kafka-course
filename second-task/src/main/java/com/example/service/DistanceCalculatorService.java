package com.example.service;

import com.example.model.OutputMessage;
import com.example.model.SignalsInput;
import com.example.model.Vehicle;
import com.example.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

@Service
@RequiredArgsConstructor
public class DistanceCalculatorService {

    private final VehicleRepository vehicleRepository;
    private final Producers producers;

    public void calculateAndSendTraveledDistance(SignalsInput signalsInput) {
        Vehicle vehicle = vehicleRepository.findById(signalsInput.getId())
                .orElseThrow(IllegalArgumentException::new);

        double distance = distance(vehicle.getLastX(), vehicle.getLastY(), signalsInput.getX(), signalsInput.getY());

        vehicle.setDistance(vehicle.getDistance() + distance);
        vehicle.setLastX(signalsInput.getX());
        vehicle.setLastY(signalsInput.getY());
        vehicleRepository.save(vehicle);

        producers.sendOutputMessage(
                OutputMessage.builder()
                        .id(vehicle.getId())
                        .totalDistance(vehicle.getDistance())
                        .lastTraveledDistance(distance)
                        .build()
        );

    }

    private double distance(Integer x1, Integer y1, Integer x2, Integer y2) {
        return sqrt(pow(x1 - x2, 2) + pow(y1-y2, 2));
    }

}
