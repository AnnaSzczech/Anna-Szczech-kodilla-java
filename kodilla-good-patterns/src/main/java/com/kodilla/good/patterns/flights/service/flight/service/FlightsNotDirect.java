package com.kodilla.good.patterns.flights.service.flight.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightsNotDirect implements Flights {
    @Override
    public Set<FlightRoute> findSpecificFlights(FlightRoute flightRouteRequest, Set<FlightRoute> listOfFlightsRoute) {
        String cityFrom = flightRouteRequest.getFrom();
        String cityTo = flightRouteRequest.getTo();

        Set<String> allCities = new HashSet<>();
        listOfFlightsRoute.stream().forEach(flightRoute -> {
            allCities.add(flightRoute.getFrom());
            allCities.add(flightRoute.getTo());
                });

        if (allCities.contains(cityFrom) && allCities.contains(cityTo)) {
            return listOfFlightsRoute.stream()
                    .filter(flightRoute -> flightRoute.getFrom().equals(cityFrom) || flightRoute.getTo().equals(cityTo))
                    .collect(Collectors.toSet());
        } else {
            return new HashSet<>();
        }

    }
}
