package org.example.services;

import org.example.entities.Flight;
import org.example.enums.SortType;

import java.util.List;

public interface FlightService {
    void addFlight(Flight flight);
    List<Flight> searchFlight(String from,String to,
                              int departDate,int paxCount);
    List<Flight> searchFlightByPreferredAirline(String from, String to,
                                                int departDate, int departTime, int paxCount,
                                             String preferredAirline, String sortBy, SortType sortType);
}

