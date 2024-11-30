package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class FareType {
    private String fareType;
    private double price;
    private List<Seat> availableSeats;

    public FareType(String fareType,double price){
        this.fareType=fareType;
        this.price=price;
        this.availableSeats=new ArrayList<>();
    }

    public double getPrice() {
        return price;
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> seatsAvailable = new ArrayList<>();
        for (Seat seat:availableSeats){
            if(!seat.isBooked()){
                seatsAvailable.add(seat);
            }
        }
        return seatsAvailable;
    }

    public String getFareType() {
        return fareType;
    }
    public void addSeat(Seat seat){
        availableSeats.add(seat);
    }

}
