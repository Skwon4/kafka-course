package com.example.service;

import com.example.model.OutputMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoggingConsumer {

    @KafkaListener(topics = "${spring.kafka.output-topic.name}", groupId = "2")
    public void consume(OutputMessage outputMessage) {
        log.info(outputMessage.toString());
    }
}
