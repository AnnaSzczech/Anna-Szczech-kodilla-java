package com.kodilla.rps.round;

import java.util.HashMap;
import java.util.Map;

public final class ListOfRounds {
    private final Map<Integer, Round> listOfRounds = new HashMap<>();

    public ListOfRounds(int numberOfRound, Round roundResult) {
        listOfRounds.put(numberOfRound, roundResult);
    }

    public HashMap<Integer, Round> getListOfRounds() {
        return new HashMap<>(listOfRounds);
    }
}
