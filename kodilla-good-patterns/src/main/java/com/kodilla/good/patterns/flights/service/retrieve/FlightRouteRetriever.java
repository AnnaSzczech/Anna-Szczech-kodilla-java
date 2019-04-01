package com.kodilla.good.patterns.flights.service.retrieve;

import com.kodilla.good.patterns.flights.service.flight.service.FlightRoute;

public class FlightRouteRetriever {

    public FlightRouteRequest retrieveFirst(){
        User user = new User("Paweł", "Nowak");
        FlightRoute flightRoute = new FlightRoute("Gdańsk", "Rzeszów");
        return new FlightRouteRequest(user, flightRoute, false);
    }

    public FlightRouteRequest retrieveSecond(){
        User user = new User("Karol", "Smith");
        FlightRoute flightRoute = new FlightRoute("Warszawa", "Kraków");
        return new FlightRouteRequest(user, flightRoute, false);
    }
}
