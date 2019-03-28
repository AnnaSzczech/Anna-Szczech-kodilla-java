package com.kodilla.good.patterns.food2door.information.service;

import com.kodilla.good.patterns.food2door.process.User;

public class MailService implements InformationService {
    @Override
    public void inform(User user, String message) {
        System.out.println("Send email to: " + user + " / Email text: " + message);
    }
}
