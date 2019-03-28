package com.kodilla.good.patterns.car.rent;

import com.kodilla.good.patterns.car.rent.implementation.CarRentalRepository;
import com.kodilla.good.patterns.car.rent.implementation.CarRentalService;
import com.kodilla.good.patterns.car.rent.implementation.MailService;

public class Application {
    public static void main(String[] args) {

        RentRequestRetriever rentRequestRetriever = new RentRequestRetriever();
        RentRequest rentRequest = rentRequestRetriever.retrieve();

        RentalProcessor rentalProcessor = new RentalProcessor(new MailService(), new CarRentalService(), new CarRentalRepository());
        rentalProcessor.process(rentRequest);

    }
}
