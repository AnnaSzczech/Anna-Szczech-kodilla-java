package com.kodilla.rps.movement;

public enum Move {
    ROCK, PAPER, SCISSORS;

    public String toString() {
        return super.toString().toLowerCase();
    }
}
