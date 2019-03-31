package com.kodilla.good.patterns.flights.service.retrieve;

import com.kodilla.good.patterns.flights.service.flight.service.FlightRoute;

public class FlightRouteRequest {
    private final User user;
    private final FlightRoute flightRoute;
    private final boolean isConnectionDirect;

    public FlightRouteRequest(User user, FlightRoute flightRoute, boolean isConnectionDirect) {
        this.user = user;
        this.flightRoute = flightRoute;
        this.isConnectionDirect = isConnectionDirect;
    }

    public User getUser() {
        return user;
    }

    public FlightRoute getFlightRoute() {
        return flightRoute;
    }

    public boolean isConnectionDirect() {
        return isConnectionDirect;
    }
}
