package com.kodilla.rps.movement.moves;

import com.kodilla.rps.movement.Move;
import com.kodilla.rps.movement.Player;

public final class Scissors implements Player {
//    private final Move move;

//    public Scissors(final Move move){
//        this.move = move;
//    }

    public Move getMove() {
        return Move.SCISSORS;
    }

    public boolean isWin(Move move){
        boolean result = false;
        if (move.equals(Move.PAPER)) result = true;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != getClass()) return false;

        Scissors scissors = (Scissors) o;

        return getMove() == scissors.getMove();
    }

    @Override
    public int hashCode() {
        return getMove().hashCode();
    }
}
