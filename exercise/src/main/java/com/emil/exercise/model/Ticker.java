package com.emil.exercise.model;

import java.util.UUID;

// Model class to represent a stock ticker buy and sell price at a point of time.

public class Ticker {

    private String id= UUID.randomUUID().toString();
    private String symbol;
    private String buy;
    private String sell;
    private String timestamp;

    public String getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
