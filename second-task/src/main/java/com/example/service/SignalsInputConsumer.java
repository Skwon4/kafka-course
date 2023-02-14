package com.example.service;

import com.example.model.SignalsInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SignalsInputConsumer {

    private final DistanceCalculatorService distanceCalculatorService;

    @KafkaListener(topics = "${spring.kafka.input-topic.name}", groupId = "1")
    public void consumerFirst(SignalsInput signalsInput) {
        distanceCalculatorService.calculateAndSendTraveledDistance(signalsInput);
        log.info("Message was consumed from input topic: " + signalsInput);
    }

    @KafkaListener(topics = "${spring.kafka.input-topic.name}", groupId = "1")
    public void consumerSecond(SignalsInput signalsInput) {
        distanceCalculatorService.calculateAndSendTraveledDistance(signalsInput);
        log.info("Message was consumed from input topic: " + signalsInput);
    }

    @KafkaListener(topics = "${spring.kafka.input-topic.name}", groupId = "1")
    public void consumerThird(SignalsInput signalsInput) {
        distanceCalculatorService.calculateAndSendTraveledDistance(signalsInput);
        log.info("Message was consumed from input topic: " + signalsInput);
    }
}
