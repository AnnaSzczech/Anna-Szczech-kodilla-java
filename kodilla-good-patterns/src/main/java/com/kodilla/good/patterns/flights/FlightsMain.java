package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.service.*;
import com.kodilla.good.patterns.flights.service.flight.service.FlightsFromSpecificCity;
import com.kodilla.good.patterns.flights.service.flight.service.FlightsNotDirect;
import com.kodilla.good.patterns.flights.service.flight.service.FlightsToSpecificCity;
import com.kodilla.good.patterns.flights.service.retrieve.FlightRouteRequest;
import com.kodilla.good.patterns.flights.service.retrieve.FlightRouteRetriever;

public class FlightsMain {

    public static void main(String[] args) {
        FlightRouteRetriever flightRouteRetriever = new FlightRouteRetriever();
        FlightRouteRequest flightRouteRequest1 = flightRouteRetriever.retrieveFirst();
        FlightRouteRequest flightRouteRequest2 = flightRouteRetriever.retrieveSecond();
        FlightRouteRequest flightRouteRequest3 = flightRouteRetriever.retrieveThird();
        FlightRouteRequest flightRouteRequest4 = flightRouteRetriever.retrieveFourth();

        FlightsServiceProcessor flightsServiceProcessor1 = new FlightsServiceProcessor(new FlightsFromSpecificCity(), new MailService());
        flightsServiceProcessor1.process(flightRouteRequest1);

        FlightsServiceProcessor flightsServiceProcessor2 = new FlightsServiceProcessor(new FlightsToSpecificCity(), new MailService());
        flightsServiceProcessor2.process(flightRouteRequest2);

        FlightsServiceProcessor flightsServiceProcessor3 = new FlightsServiceProcessor(new FlightsNotDirect(), new MailService());
        flightsServiceProcessor3.process(flightRouteRequest3);

        FlightsServiceProcessor flightsServiceProcessor4 = new FlightsServiceProcessor(new FlightsNotDirect(), new MailService());
        flightsServiceProcessor4.process(flightRouteRequest4);
    }
}
