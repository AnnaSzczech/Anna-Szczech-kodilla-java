package com.kodilla.good.patterns.flights.service.flight.service;

import java.util.*;

public class FlightsRouteDB {

    public Set<FlightRoute> downloadDB(){
        Set<FlightRoute> flights = new HashSet<>();
        flights.add(new FlightRoute("Gdańsk", "Wrocław"));
        flights.add(new FlightRoute("Gdańsk", "Rzeszów"));
        flights.add(new FlightRoute("Poznań", "Rzeszów"));
        flights.add(new FlightRoute("Wrocław", "Gdańsk"));
        flights.add(new FlightRoute("Rzeszów", "Gdańsk"));
        flights.add(new FlightRoute("Rzeszów", "Poznań"));
        flights.add(new FlightRoute("Gdańsk", "Poznań"));
        flights.add(new FlightRoute("Poznań", "Wrocław"));
        flights.add(new FlightRoute("Gdańsk", "Warszawa"));
        flights.add(new FlightRoute("Warszawa", "Rzeszów"));
        flights.add(new FlightRoute("Gdańsk", "Łódź"));
        flights.add(new FlightRoute("Łódź", "Rzeszów"));
        flights.add(new FlightRoute("Poznań", "Łódź"));
        flights.add(new FlightRoute("Wrocław", "Rzeszów"));
        flights.add(new FlightRoute("Łódź", "Gdańsk"));
        flights.add(new FlightRoute("Rzeszów", "Warszawa"));
        flights.add(new FlightRoute("Wrocław","Poznań"));
        flights.add(new FlightRoute("Poznań", "Gdańsk"));
        flights.add(new FlightRoute("Rzeszów", "Łódź"));
        flights.add(new FlightRoute("Warszawa", "Gdańsk"));
        flights.add(new FlightRoute("Rzeszów", "Wrocław"));
        flights.add(new FlightRoute("Łódź", "Poznań"));
        return flights;

    }
}
