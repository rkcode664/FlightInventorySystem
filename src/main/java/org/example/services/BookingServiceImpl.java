package org.example.services;

import org.example.entities.Booking;
import org.example.entities.Flight;
import org.example.entities.Seat;
import org.example.entities.User;
import org.example.exceptions.InsufficientFundsException;
import org.example.exceptions.SeatNotAvailableException;

import java.util.ArrayList;
import java.util.List;

public class BookingServiceImpl implements BookingService{
    private List<Booking> bookings;
    public BookingServiceImpl(){
        this.bookings=new ArrayList<>();
    }
    @Override
    public String createBooking(User user, Flight flight, String fareType, List<String> seats){
        var fare = flight.getFareTypes().get(fareType);
        double totalPrice = fare.getPrice()*seats.size();
        if(user.getFunds()<totalPrice){
            throw new InsufficientFundsException("User has insufficient funds");
        }
        for(String seatNumber:seats){
            Seat seat = fare.getAvailableSeats().stream().filter(s->s.getSeatNumber().equals(seatNumber)).findFirst().orElse(null);
            if(seat==null || seat.isBooked()){
                throw new SeatNotAvailableException("Seat not available");
            }
            seat.bookSeat();
        }
        user.deductFunds(totalPrice);
        bookings.add(new Booking(user.getUserId(),flight.getFlightNumber(),fareType,seats));
        return "Booking Succesfull";
    }
}
