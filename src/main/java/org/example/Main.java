package org.example;

import org.example.entities.FareType;
import org.example.entities.Flight;
import org.example.entities.Seat;
import org.example.entities.User;
import org.example.enums.SortType;
import org.example.managers.UserManager;
import org.example.services.BookingService;
import org.example.services.BookingServiceImpl;
import org.example.services.FlightService;
import org.example.services.FlightServiceImpl;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            FlightService flightService = new FlightServiceImpl();
            UserManager userManager = new UserManager();
            //create user1
            User user1 = userManager.addUser("u1", "Vinit", 5000);
            //create user1
            User user2 = userManager.addUser("u2", "Neha", 3000);
            //create flight 1
            Flight flight1 = new Flight("123", "6E", "DEL", "BLR", 2, 10);
            FareType fareType1 = new FareType("F1", 2000);
            fareType1.addSeat(new Seat("1B"));
            fareType1.addSeat(new Seat("2C"));
            fareType1.addSeat(new Seat("4E"));
            flight1.addFareType(fareType1);
            flightService.addFlight(flight1);

            //create flight 2
            Flight flight2 = new Flight("234", "6E", "DEL", "HYD", 2, 15);
            FareType fareType2 = new FareType("F3", 1000);
            fareType2.addSeat(new Seat("29A"));
            fareType2.addSeat(new Seat("40E"));
            fareType2.addSeat(new Seat("1E"));
            fareType2.addSeat(new Seat("4E"));
            flight2.addFareType(fareType2);
            flightService.addFlight(flight2);

            //create flight 3
            Flight flight3 = new Flight("156", "6E", "DEL", "BLR", 2, 14);
            FareType fareType3 = new FareType("F1", 4000);
            fareType3.addSeat(new Seat("4E"));
            flight3.addFareType(fareType3);
            flightService.addFlight(flight3);


            var availableFlights = flightService.searchFlight("DEL", "BLR", 2, 1);
            System.out.println("Available Flights: " + availableFlights.size());


            //Booking
            BookingService bookingService = new BookingServiceImpl();

            //to check for insufficient funds error uncomment the below line
            //User user1 = userManager.addUser("u1","Vinit", 100);

            String bookingResponse = bookingService.createBooking(user1, flight1, "F1", Arrays.asList("1B"));
            System.out.println(bookingResponse);

            //Bonus sort by price
            List<Flight> availableFlightsPreffered = flightService.searchFlightByPreferredAirline("DEL", "BLR", 2, 10, 1, "6E", "price", SortType.DESCENDING);
            for (Flight flight : availableFlightsPreffered) {
                System.out.println("Sorted Flight number "+flight.getFlightNumber() +" and Flight Price "+flight.getFareTypes().get("F1").getPrice());
            }

            //sort by departure time
            List<Flight> availableFlightsPrefferedDepartTime = flightService.searchFlightByPreferredAirline("DEL", "BLR", 2, 10, 1, "6E", "departtime", SortType.DESCENDING);
            for (Flight flight : availableFlightsPreffered) {
                System.out.println("Sorted Flight number "+flight.getFlightNumber() +" and Flight time "+flight.getDepartTime());
            }

            // user 2 trying to book the same seat as user 1
            String bookingResponse2 = bookingService.createBooking(user2, flight1, "F1", Arrays.asList("1B"));
            System.out.println(bookingResponse2);


        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}