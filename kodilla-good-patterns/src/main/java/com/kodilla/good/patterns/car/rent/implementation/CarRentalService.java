package com.kodilla.good.patterns.car.rent.implementation;

import com.kodilla.good.patterns.car.rent.User;
import com.kodilla.good.patterns.car.rent.interfaces.RentalService;

import java.time.LocalDateTime;

public class CarRentalService implements RentalService {

    @Override
    public boolean rent(final User user, final LocalDateTime carRentFrom, final LocalDateTime carRentTo){
        System.out.println("Renting Car for: " + user + " from: " + carRentFrom + " to: " + carRentTo);
        return true;
    }
}
