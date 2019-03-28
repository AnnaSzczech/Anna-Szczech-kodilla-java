package com.kodilla.good.patterns.car.rent.interfaces;

import com.kodilla.good.patterns.car.rent.User;

import java.time.LocalDateTime;

public interface RentalRepository {
    void createRental(User user, LocalDateTime from, LocalDateTime to);
}
