package com.kodilla.good.patterns.flights.service.flight.service;

import java.util.Set;
import java.util.stream.Collectors;

public class FlightsToSpecificCity implements Flights {
    @Override
    public Set<FlightRoute> findSpecificFlights(FlightRoute flightRouteRequest, Set<FlightRoute> listOfFlightsRoute) {
        String city = flightRouteRequest.getTo();
        return listOfFlightsRoute.stream()
                .filter(flightRoute -> flightRoute.getTo().equals(city))
                .collect(Collectors.toSet());
    }
}
