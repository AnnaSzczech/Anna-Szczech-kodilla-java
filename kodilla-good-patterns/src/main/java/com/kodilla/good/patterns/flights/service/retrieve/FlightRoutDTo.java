package com.kodilla.good.patterns.flights.service.retrieve;

import com.kodilla.good.patterns.flights.service.flight.service.FlightRouteCombo;

import java.util.Set;

public class FlightRoutDTo {
    private final Set<FlightRouteCombo> flightRoute;
    private final boolean exist;

    public FlightRoutDTo(Set<FlightRouteCombo> flightRoute, boolean exist) {
        this.flightRoute = flightRoute;
        this.exist = exist;
    }

    public Set<FlightRouteCombo> getFlightRoute() {
        return flightRoute;
    }

    public boolean isExist() {
        return exist;
    }
}
