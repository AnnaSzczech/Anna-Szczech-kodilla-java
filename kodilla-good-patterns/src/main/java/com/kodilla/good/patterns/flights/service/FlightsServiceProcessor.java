package com.kodilla.good.patterns.flights.service;

import com.kodilla.good.patterns.flights.service.flight.service.FlightRoute;
import com.kodilla.good.patterns.flights.service.flight.service.FlightRouteCombo;
import com.kodilla.good.patterns.flights.service.flight.service.FlightRouteService;
import com.kodilla.good.patterns.flights.service.retrieve.FlightRoutDTo;
import com.kodilla.good.patterns.flights.service.retrieve.FlightRouteRequest;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightsServiceProcessor {
    private final MailService mailService;
    private final FlightRouteService flightRouteService;

    public FlightsServiceProcessor(FlightRouteService flightRouteService, MailService mailService) {
        this.flightRouteService = flightRouteService;
        this.mailService = mailService;
    }

    public FlightRoutDTo process(FlightRouteRequest flightRouteRequest){
        Set<FlightRouteCombo> listOfFlightsNotDirect = flightRouteService.findFlightsNoDirect(flightRouteRequest.getFlightRoute());
        if (listOfFlightsNotDirect.size() != 0) {
            String message = listOfFlightsNotDirect.stream()
                    .map(routeFlights -> routeFlights.toString())
                    .collect(Collectors.joining("\n", "\n", "\n"));
            mailService.inform(flightRouteRequest.getUser(), "Found flight route: " + message);
            return new FlightRoutDTo(listOfFlightsNotDirect, true);
        } else {
            mailService.inform(flightRouteRequest.getUser(), "Flight route not found!\n");
            return new FlightRoutDTo(listOfFlightsNotDirect, false);
        }
    }
}
