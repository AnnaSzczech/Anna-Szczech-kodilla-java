package com.kodilla.rps.movement.moves;

import com.kodilla.rps.movement.Move;
import com.kodilla.rps.movement.Player;

public final class Rock implements Player {
//    private final Move move;

//    public Rock(final Move move){
//        this.move = move;
//    }

    public Move getMove() {
        return Move.ROCK;
    }

    public boolean isWin(Move move){
        boolean result = false;
        if (move.equals(Move.SCISSORS)) result = true;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != getClass()) return false;

        Rock rock = (Rock) o;

        return getMove() == rock.getMove();
    }

    @Override
    public int hashCode() {
        return getMove().hashCode();
    }
}
