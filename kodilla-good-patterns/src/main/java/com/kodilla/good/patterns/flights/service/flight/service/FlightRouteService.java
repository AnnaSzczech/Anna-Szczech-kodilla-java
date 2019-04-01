package com.kodilla.good.patterns.flights.service.flight.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightRouteService {
    private final Set<FlightRoute> listOfFlightsRoute;
    private int a = 1;

    public FlightRouteService() {
        FlightsRouteDB flightsRouteDB = new FlightsRouteDB();
        this.listOfFlightsRoute = flightsRouteDB.downloadDB();
    }

    public Set<FlightRoute> findFlightsFromSpecificCity(FlightRoute flightRouteRequest) {
        String city = flightRouteRequest.getFrom();
        return listOfFlightsRoute.stream()
                .filter(flightRoute -> flightRoute.getFrom().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<FlightRoute> findFlightsToSpecificCity(FlightRoute flightRouteRequest) {
        String city = flightRouteRequest.getTo();
        return listOfFlightsRoute.stream()
                .filter(flightRoute -> flightRoute.getTo().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<FlightRouteCombo> findFlightsNoDirect(FlightRoute flightRouteRequest) {
        Set<FlightRoute> listOfFlightsFromSpecificCity = findFlightsFromSpecificCity(flightRouteRequest);
        Set<FlightRoute> listOfFlightsToSpecificCity = findFlightsToSpecificCity(flightRouteRequest);

        Set<FlightRouteCombo> listOfFlightsNotDirect = new HashSet<>();
        listOfFlightsFromSpecificCity.stream()
                .forEach(flightsRoute1 -> {
                    listOfFlightsToSpecificCity.stream()
                            .forEach(flightsRoute2 -> {
                                if (flightsRoute1.getTo().equals(flightsRoute2.getFrom())) {
                                    listOfFlightsNotDirect.add(new FlightRouteCombo(flightsRoute1, flightsRoute2));
                                }
                            });
                });
        return listOfFlightsNotDirect;
    }

}
