package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.service.*;
import com.kodilla.good.patterns.flights.service.flight.service.FlightRouteService;
import com.kodilla.good.patterns.flights.service.retrieve.FlightRouteRequest;
import com.kodilla.good.patterns.flights.service.retrieve.FlightRouteRetriever;

public class FlightsMain {

    public static void main(String[] args) {
        FlightRouteRetriever flightRouteRetriever = new FlightRouteRetriever();
        FlightRouteRequest flightRouteRequest1 = flightRouteRetriever.retrieveFirst();
        FlightRouteRequest flightRouteRequest2 = flightRouteRetriever.retrieveSecond();

        FlightsServiceProcessor flightsServiceProcessor1 = new FlightsServiceProcessor(new FlightRouteService(), new MailService());
        flightsServiceProcessor1.process(flightRouteRequest1);

        FlightsServiceProcessor flightsServiceProcessor2 = new FlightsServiceProcessor(new FlightRouteService(), new MailService());
        flightsServiceProcessor2.process(flightRouteRequest2);
    }
}
