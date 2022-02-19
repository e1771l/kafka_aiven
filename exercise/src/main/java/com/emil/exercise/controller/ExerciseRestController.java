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


    @Autowired
    private KafkaProducer kafkaProducer;


    //get TimeStamp in ISO8601 format
    private String getTimeStamp(){
        return ZonedDateTime.now( ZoneOffset.UTC ).format( DateTimeFormatter.ISO_INSTANT );
    }

    @GetMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("symbol") String symbol) {
        Ticker ticker = new Ticker(); 

        ticker.setSymbol(symbol);
        ticker.setBuy("172.01");
        ticker.setSell("174.01");
        ticker.setTimestamp(this.getTimeStamp());

        this.kafkaProducer.sendMessage(ticker);
    }
    
}
