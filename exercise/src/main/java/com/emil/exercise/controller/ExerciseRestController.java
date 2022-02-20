package com.emil.exercise.controller;


import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.emil.exercise.kafka.KafkaProducer;
import com.emil.exercise.model.Ticker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exercise")
public class ExerciseRestController {

    //Inject the KafkaProducer service
    @Autowired
    private KafkaProducer kafkaProducer;

    //get TimeStamp in ISO8601 format
    private String getTimeStamp(){
        return ZonedDateTime.now( ZoneOffset.UTC ).format( DateTimeFormatter.ISO_INSTANT );
    }

    //Publish Kafka Even everytime a GET request is received on URI /exercise/publish    
    @GetMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("symbol") String symbol, 
                                        @RequestParam("buy") String buy, 
                                        @RequestParam("sell") String sell) {
        //Initiate Ticker object, from request parameter
        Ticker ticker = new Ticker(); 

        ticker.setSymbol(symbol);
        ticker.setBuy(buy);
        ticker.setSell(sell);
        ticker.setTimestamp(this.getTimeStamp());

        //Publish Ticker Object to Kafka broker in JSON format
        this.kafkaProducer.sendMessage(ticker);
    }
    
}
