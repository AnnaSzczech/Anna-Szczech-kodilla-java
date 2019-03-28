package com.kodilla.good.patterns.car.rent.implementation;

import com.kodilla.good.patterns.car.rent.User;
import com.kodilla.good.patterns.car.rent.interfaces.InformationService;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("You: " + user + " has rent a car.");
    }
}
