package com.kodilla.good.patterns.flights.service;

import com.kodilla.good.patterns.flights.service.flight.service.FlightRoute;
import com.kodilla.good.patterns.flights.service.flight.service.Flights;
import com.kodilla.good.patterns.flights.service.flight.service.FlightsRouteDB;
import com.kodilla.good.patterns.flights.service.retrieve.FlightRoutDTo;
import com.kodilla.good.patterns.flights.service.retrieve.FlightRouteRequest;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FlightsServiceProcessor {
    private final Flights flights;
    private final MailService mailService;

    public FlightsServiceProcessor(Flights flights, MailService mailService) {
        this.flights = flights;
        this.mailService = mailService;
    }

    public FlightRoutDTo process(FlightRouteRequest flightRouteRequest){
        FlightsRouteDB flightsRouteDB = new FlightsRouteDB();
        Set<FlightRoute> listOfFlights = flightsRouteDB.downloadDB();
        listOfFlights = flights.findSpecificFlights(flightRouteRequest.getFlightRoute(), listOfFlights);
        if (listOfFlights.size() != 0) {
            mailService.inform(flightRouteRequest.getUser(), "Found flight route: " + listOfFlights.stream().map(n -> n.toString()).collect(Collectors.joining("\n", "\n", "\n")));
            return new FlightRoutDTo(listOfFlights, true);
        } else {
            mailService.inform(flightRouteRequest.getUser(), "Flight route not found!\n");
            return new FlightRoutDTo(listOfFlights, false);
        }
    }
}
