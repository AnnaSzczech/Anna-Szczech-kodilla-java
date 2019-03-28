package com.kodilla.good.patterns.car.rent.implementation;

import com.kodilla.good.patterns.car.rent.RentRequest;
import com.kodilla.good.patterns.car.rent.User;
import com.kodilla.good.patterns.car.rent.interfaces.RentalRepository;

import java.time.LocalDateTime;
import java.util.List;

public class CarRentalRepository implements RentalRepository {
    List<RentRequest> rentRequestList;

    @Override
    public void createRental(User user, LocalDateTime from, LocalDateTime to) {
        rentRequestList.add(new RentRequest(user, from, to));
    }
}
