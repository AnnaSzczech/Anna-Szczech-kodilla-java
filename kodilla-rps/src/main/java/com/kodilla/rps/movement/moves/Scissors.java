package com.kodilla.rps.movement.moves;

import com.kodilla.rps.movement.Movements;
import com.kodilla.rps.movement.PlayerMovement;

public final class Scissors implements PlayerMovement {
    private final Movements movements;

    public Scissors(final Movements movements){
        this.movements = movements;
    }

    public Movements getMovements() {
        return movements;
    }

    public boolean isSuccessful(Movements movements){
        boolean result = false;
        if (movements == Movements.PAPER) result = true;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != getClass()) return false;

        Scissors scissors = (Scissors) o;

        return getMovements() == scissors.getMovements();
    }

    @Override
    public int hashCode() {
        return getMovements().hashCode();
    }
}
