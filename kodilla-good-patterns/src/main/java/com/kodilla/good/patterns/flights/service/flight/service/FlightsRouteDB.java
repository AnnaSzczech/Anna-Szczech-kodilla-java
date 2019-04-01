package com.kodilla.good.patterns.flights.service.flight.service;

import java.util.*;

public class FlightsRouteDB {

    public Set<FlightRoute> downloadDB(){
        Set<FlightRoute> flights = new HashSet<>();
        flights.add(new FlightRoute("Gdańsk", "Warszawa"));
        flights.add(new FlightRoute("Warszawa", "Rzeszów"));

        flights.add(new FlightRoute("Gdańsk", "Łódź"));
        flights.add(new FlightRoute("Łódź", "Rzeszów"));

        flights.add(new FlightRoute("Poznań", "Warszawa"));
        flights.add(new FlightRoute("Warszawa", "Rzeszów"));


        flights.add(new FlightRoute("Gdańsk", "Poznań"));
        flights.add(new FlightRoute("Poznań", "Wrocław"));

        flights.add(new FlightRoute("Gdańsk", "Poznań"));
        flights.add(new FlightRoute("Poznań", "Rzeszów"));

        flights.add(new FlightRoute("Kraków", "Rzeszów"));

        return flights;

    }
}
