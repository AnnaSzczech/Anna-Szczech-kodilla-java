package com.kodilla.good.patterns.flights.service.flight.service;

import java.util.Set;

public interface Flights {
    Set<FlightRoute> findSpecificFlights(FlightRoute flightRouteRequest, Set<FlightRoute> listOfFlightsRoute);
}
