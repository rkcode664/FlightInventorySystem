package org.example.entities;

import java.util.List;

public class Booking {
   private static int bookingCounter = 1;
   private String bookingId;
   private String userId;
   private String flightId;
   private String fareType;
   private List<String> seatNumbers;

    public Booking(String userId, String flightId,String fareType, List<String> seatNumbers){
        this.bookingId= "BK"+(bookingCounter++);
        this.userId=userId;
        this.flightId=flightId;
        this.fareType=fareType;
        this.seatNumbers=seatNumbers;
    }
    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getFareType() {
        return fareType;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }
}
