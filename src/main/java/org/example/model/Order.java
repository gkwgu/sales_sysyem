package org.example.model;

import java.time.LocalDateTime;

public class Order {
    private final LocalDateTime dateTime;
    private final String company;
    private final int weight;

    public Order(LocalDateTime dateTime, String company, int weight) {
        this.dateTime = dateTime;
        this.company = company;
        this.weight = weight;
    }


    public int getWeight(){
        return weight;
    }


    public String getCompany() {
        return company;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
