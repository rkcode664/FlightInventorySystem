package org.example.entities;

import java.util.HashMap;
import java.util.Map;

public class Flight {
    private String flightNumber;
    private String airline;
    private String fromCity;
    private String toCity;
    private int departDate;
    private double departTime;
    private Map<String,FareType> fareTypes;

    public Flight(String flightNumber,String airline,String fromCity,String toCity,
                  int departDate,double departTime){
        this.flightNumber=flightNumber;
        this.airline=airline;
        this.fromCity=fromCity;
        this.toCity=toCity;
        this.departDate=departDate;
        this.departTime=departTime;
        this.fareTypes=new HashMap<>();
    }
    public void addFareType(FareType fareType){
        fareTypes.put(fareType.getFareType(),fareType);
    }

    public Map<String, FareType> getFareTypes() {
        return fareTypes;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public double getDepartTime() {
        return departTime;
    }

    public int getDepartDate() {
        return departDate;
    }
}
