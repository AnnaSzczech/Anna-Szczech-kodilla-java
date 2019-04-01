package com.kodilla.good.patterns.flights.service.flight.service;

public class FlightRouteCombo {
    private final FlightRoute flightRouteStart;
    private final FlightRoute flightRouteFinish;

    public FlightRouteCombo(FlightRoute flightRouteStart, FlightRoute flightRouteFinish) {
        this.flightRouteStart = flightRouteStart;
        this.flightRouteFinish = flightRouteFinish;
    }

    public FlightRoute getFlightRouteStart() {
        return flightRouteStart;
    }

    public FlightRoute getFlightRouteFinish() {
        return flightRouteFinish;
    }

    @Override
    public String toString() {
        return flightRouteStart + ", " + flightRouteFinish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightRouteCombo)) return false;

        FlightRouteCombo that = (FlightRouteCombo) o;

        if (!getFlightRouteStart().equals(that.getFlightRouteStart())) return false;
        return getFlightRouteFinish().equals(that.getFlightRouteFinish());
    }

    @Override
    public int hashCode() {
        int result = getFlightRouteStart().hashCode();
        result = 31 * result + getFlightRouteFinish().hashCode();
        return result;
    }
}
