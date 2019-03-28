package com.kodilla.good.patterns.food2door.process;

public class User {
    private final String surname;
    private final String name;

    public User(final String name, final String surname) {
        this.surname = surname;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
