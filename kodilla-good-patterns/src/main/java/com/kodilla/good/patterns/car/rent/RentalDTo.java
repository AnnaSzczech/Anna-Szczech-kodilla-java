package com.kodilla.good.patterns.car.rent;

public class RentalDTo {
    private User user;
    private boolean isRented;

    public RentalDTo(final User user, final boolean isRented) {
        this.user = user;
        this.isRented = isRented;
    }

    public User getUser() {
        return user;
    }

    public boolean isRented() {
        return isRented;
    }
}
