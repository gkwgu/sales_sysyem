package org.example.model;

import java.time.LocalDateTime;

public class Order {
    private final LocalDateTime time;
    private String company;
    private int weight;

    public Order(LocalDateTime time, String company, int weight) {
        this.time = time;
        this.company = company;
        this.weight = weight;
    }


    public int getWeight(){
        return weight;
    }


    public String getCompany() {
        return company;
    }
    public LocalDateTime getTime() {
        return time;
    }
}
