package org.example.services;

import org.example.entities.Flight;
import org.example.enums.SortType;
import org.example.exceptions.FlightNotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlightServiceImpl implements FlightService{
    private List<Flight> flights;
    public FlightServiceImpl(){
        this.flights = new ArrayList<>();
    }
    @Override
    public void addFlight(Flight flight){
        flights.add(flight);
    }
    @Override
    public List<Flight> searchFlight(String from,String to,int departDate,int paxCount){
        List<Flight> availableFlights = new ArrayList<>();
        for (Flight flight:flights){
            if(flight.getFromCity().equalsIgnoreCase(from) && flight.getToCity().equalsIgnoreCase(to)
            && flight.getDepartDate()==departDate){
                var seatsAvailable = flight.getFareTypes().values().stream().anyMatch(fareType -> fareType.getAvailableSeats().size()>=paxCount);
                if(seatsAvailable){
                    availableFlights.add(flight);
                }
            }
        }
        if (availableFlights.isEmpty()){
            throw  new FlightNotFoundException("No flights available");
        }
        return availableFlights;
    }

    @Override
    public List<Flight> searchFlightByPreferredAirline(String from, String to,
                                                       int departDate, int departTime, int paxCount,
                                                       String preferredAirline, String sortBy, SortType sortType){
        List<Flight> availableFlights = searchFlight(from,to,departDate,paxCount);
        List<Flight> preferredFlights = new ArrayList<>();
        for (Flight flight:availableFlights){
            if(flight.getAirline().equalsIgnoreCase(preferredAirline)){
                preferredFlights.add(flight);
            }
        }
        Comparator<Flight> comparator;
        switch ((sortBy.toLowerCase())){
            case "price":
                comparator=Comparator.comparingDouble(flight -> flight.getFareTypes().values().iterator().next().getPrice());
                break;
            case "departtime":
                comparator=Comparator.comparingDouble(Flight::getDepartTime);
                break;
            default:
                throw new IllegalArgumentException("Invalid sort field:" + sortBy);
        }
        if(sortType==sortType.DESCENDING){
            comparator=comparator.reversed();
        }
        preferredFlights.sort(comparator);
        return preferredFlights;
    }
}
