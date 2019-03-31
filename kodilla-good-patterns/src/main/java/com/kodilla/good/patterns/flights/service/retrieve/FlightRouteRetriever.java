package com.kodilla.good.patterns.flights.service.retrieve;

import com.kodilla.good.patterns.flights.service.flight.service.FlightRoute;

public class FlightRouteRetriever {

    public FlightRouteRequest retrieveFirst(){
        User user = new User("Anna", "Szczech");
        FlightRoute flightRoute = new FlightRoute("Warszawa", null);
        return new FlightRouteRequest(user, flightRoute, true);
    }

    public FlightRouteRequest retrieveSecond(){
        User user = new User("Jan", "Kowalski");
        FlightRoute flightRoute = new FlightRoute(null, "Rzeszów");
        return new FlightRouteRequest(user, flightRoute, true);
    }

    public FlightRouteRequest retrieveThird(){
        User user = new User("Paweł", "Nowak");
        FlightRoute flightRoute = new FlightRoute("Warszawa", "Rzeszów");
        return new FlightRouteRequest(user, flightRoute, false);
    }

    public FlightRouteRequest retrieveFourth(){
        User user = new User("Karol", "Smith");
        FlightRoute flightRoute = new FlightRoute("Warszawa", "Kraków");
        return new FlightRouteRequest(user, flightRoute, false);
    }
}
