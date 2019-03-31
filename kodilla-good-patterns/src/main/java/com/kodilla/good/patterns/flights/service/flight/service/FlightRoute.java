package com.kodilla.good.patterns.flights.service.flight.service;

public class FlightRoute {
    private final String from;
    private final String to;

    public FlightRoute(String from, String to){
        this.from = from;
        this.to = to;
    }

    public String getFrom(){
        return from;
    }

    public String getTo(){
        return to;
    }

    @Override
    public String toString() {
        return "FlightRoute: " + from + " -> " + to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightRoute)) return false;

        FlightRoute that = (FlightRoute) o;

        if (!getFrom().equals(that.getFrom())) return false;
        return getTo().equals(that.getTo());
    }

    @Override
    public int hashCode() {
        int result = getFrom().hashCode();
        result = 31 * result + getTo().hashCode();
        return result;
    }
}
