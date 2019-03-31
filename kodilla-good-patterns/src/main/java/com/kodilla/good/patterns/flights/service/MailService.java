package com.kodilla.good.patterns.flights.service;

import com.kodilla.good.patterns.flights.service.retrieve.User;

public class MailService implements InformationService {
    @Override
    public void inform(User user, String message) {
        System.out.println("Email to: " + user + ", message: " + message);
    }
}
