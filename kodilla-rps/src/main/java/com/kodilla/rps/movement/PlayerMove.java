package com.kodilla.rps.movement;

public interface PlayerMove {
    boolean isSuccessful(Move move);
    Move getMove();
}
