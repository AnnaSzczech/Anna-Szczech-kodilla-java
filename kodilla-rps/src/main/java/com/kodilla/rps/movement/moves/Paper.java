package com.kodilla.rps.movement.moves;

import com.kodilla.rps.movement.Move;
import com.kodilla.rps.movement.Player;

public final class Paper implements Player {
//    private final Move move;

//    public Paper(final Move move){
//        this.move = move;
//    }

    public Move getMove() {
        return Move.PAPER;
    }

    public boolean isWin(Move move) {
        boolean result = false;
        if (move.equals(Move.ROCK)) result = true;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != getClass()) return false;

        Paper paper = (Paper) o;

        return getMove() == paper.getMove();
    }

    @Override
    public int hashCode() {
        return getMove().hashCode();
    }
}
