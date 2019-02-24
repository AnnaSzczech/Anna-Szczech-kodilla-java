package com.kodilla.rps.score;

import com.kodilla.rps.movement.Player;

public final class Round {
    private final Player userMove;
    private final Player computerMove;

    public Round(final Player userMove, final Player computerMove) {
        this.userMove = userMove;
        this.computerMove = computerMove;
    }

    public Player getPlayerMove() {
        return userMove;
    }

    public Player getComputerMove() {
        return computerMove;
    }

    @Override
    public String toString() {
        return  userMove.getMove() + " : " + computerMove.getMove();
    }
}
