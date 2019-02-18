package com.kodilla.rps.score;

import com.kodilla.rps.movement.PlayerMove;

public final class Round {
    private final PlayerMove playerMove;
    private final PlayerMove computerMove;

    public Round(final PlayerMove playerMove, final PlayerMove computerMove) {
        this.playerMove = playerMove;
        this.computerMove = computerMove;
    }

    public PlayerMove getPlayerMove() {
        return playerMove;
    }

    public PlayerMove getComputerMove() {
        return computerMove;
    }

    @Override
    public String toString() {
        return  playerMove.getMove() + " : " + computerMove.getMove();
    }
}
