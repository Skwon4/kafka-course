package com.example.service;

import com.example.model.OutputMessage;
import com.example.model.SignalsInput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producers {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value(value = "${spring.kafka.input-topic.name}")
    private String inputTopic;
    @Value(value = "${spring.kafka.output-topic.name}")
    private String outputTopic;

    public void sendInputSignalsMessage(SignalsInput signalsInput) {
        kafkaTemplate.send(inputTopic, signalsInput);
    }

    public void sendOutputMessage(OutputMessage outputMessage) {
        kafkaTemplate.send(outputTopic, outputMessage);
    }
}
