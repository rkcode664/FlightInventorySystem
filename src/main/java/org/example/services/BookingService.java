package org.example.services;

import org.example.entities.Flight;
import org.example.entities.User;

import java.util.List;

public interface BookingService {
    String createBooking(User user, Flight flight, String fareType, List<String> seats);
}
