package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {


    public Flight findFlight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> flights = new HashMap<>();
        flights.put("Chopin Airport", true);


        if (!(flights.containsKey(flight.getArrivalAirport()))) {
            throw new RouteNotFoundException();
        }

        return flight;
    }

    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();
        try {
            Flight flight = flightSearch.findFlight(new Flight("airport2", "airport3"));
            System.out.println("Flight 2: " + flight);
        } catch (RouteNotFoundException e){
            System.out.println("There is no such route on the list! Error: " + e);
        } finally {
            System.out.println("End of Program.");
        }
    }
}
