package org.example.entities;

public class Seat {
    private String seatNumber;
    private boolean isBooked = false;

    public Seat(String seatNumber){
        this.seatNumber=seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    public boolean isBooked(){
        return isBooked;
    }
    public  void bookSeat(){
        this.isBooked=true;
    }
}
