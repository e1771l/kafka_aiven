package com.emil.exercise.kafka;

import java.util.UUID;

import com.emil.exercise.model.Ticker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private static final String kafkaTopic="stockTicker";


    //Use config in Spring application.properties to create kafka producer
    @Autowired
    private KafkaTemplate<String, Ticker> kafkaTemplate;

    public void sendMessage(Ticker ticker) {
        logger.info(String.format("publishing ==>", ticker.getSymbol()));

        
        String key=UUID.randomUUID().toString();
        this.kafkaTemplate.send(kafkaTopic, key, ticker);
    }

    
}
