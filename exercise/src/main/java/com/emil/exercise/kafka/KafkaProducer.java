package com.emil.exercise.kafka;

import java.util.UUID;

import com.emil.exercise.model.Ticker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    //We are just going to hardcode Kafka Topic to be used to publish message for this demo
    private static final String kafkaTopic="stockTicker";

    /*Initiate Kafka Template with spring-kafka dependency injection based on application.properties */
    @Autowired
    private KafkaTemplate<String, Ticker> kafkaTemplate;

    /*Convenient method to pubish a messave to kafka broker*/
    public void sendMessage(Ticker ticker) {
        // Using Random UUID as key for the Kafka Event
        String key=UUID.randomUUID().toString();
        
        this.kafkaTemplate.send(kafkaTopic, key, ticker);
    }
}
