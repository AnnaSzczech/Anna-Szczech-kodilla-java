package com.kodilla.good.patterns.flights.service.retrieve;

import com.kodilla.good.patterns.flights.service.flight.service.FlightRoute;

import java.util.Set;

public class FlightRoutDTo {
    private final Set<FlightRoute> flightRoute;
    private final boolean exist;

    public FlightRoutDTo(Set<FlightRoute> flightRoute, boolean exist) {
        this.flightRoute = flightRoute;
        this.exist = exist;
    }

    public Set<FlightRoute> getFlightRoute() {
        return flightRoute;
    }

    public boolean isExist() {
        return exist;
    }
}
