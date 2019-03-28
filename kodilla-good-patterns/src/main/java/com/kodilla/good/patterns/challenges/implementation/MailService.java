package com.kodilla.good.patterns.challenges.implementation;

import com.kodilla.good.patterns.challenges.User;
import com.kodilla.good.patterns.challenges.interfaces.InformationService;

public class MailService implements InformationService {

    @Override
    public void inform(User user, String message) {
        System.out.println("INFORMATION SERVICE!!!  ->  User: " + user + message);
    }
}

