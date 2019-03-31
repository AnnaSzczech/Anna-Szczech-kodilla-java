package com.kodilla.good.patterns.flights.service.flight.service;

import java.util.Set;
import java.util.stream.Collectors;

public class FlightsFromSpecificCity implements Flights {
    @Override
    public Set<FlightRoute> findSpecificFlights(FlightRoute flightRouteRequest, Set<FlightRoute> listOfFlightsRoute) {
        String city = flightRouteRequest.getFrom();
        return listOfFlightsRoute.stream()
                .filter(flightRoute -> flightRoute.getFrom().equals(city))
                .collect(Collectors.toSet());
    }
}
