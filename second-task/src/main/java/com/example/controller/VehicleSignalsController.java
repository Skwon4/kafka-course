package com.example.controller;

import com.example.model.SignalsInput;
import com.example.repository.VehicleRepository;
import com.example.service.Producers;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("signals")
public class VehicleSignalsController {

    private final VehicleRepository vehicleRepository;
    private final Producers producers;

    @PostMapping("send")
    public ResponseEntity<String> updateCoordinates(@Valid @RequestBody SignalsInput signalsInput) {
        validateInput(signalsInput);
        producers.sendInputSignalsMessage(signalsInput);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    private void validateInput(SignalsInput signalsInput) {
        vehicleRepository.findById(signalsInput.getId())
                .orElseThrow(IllegalArgumentException::new);
    }

}
