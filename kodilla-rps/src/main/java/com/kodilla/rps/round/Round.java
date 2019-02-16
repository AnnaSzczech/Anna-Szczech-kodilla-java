package com.kodilla.rps.round;

import com.kodilla.rps.movement.PlayerMovement;

public final class Round {
    private final PlayerMovement playerMove;
    private final PlayerMovement computerMove;

    public Round(final PlayerMovement playerMove, final PlayerMovement computerMove) {
        this.playerMove = playerMove;
        this.computerMove = computerMove;
    }

    public PlayerMovement getPlayerMove() {
        return playerMove;
    }

    public PlayerMovement getComputerMove() {
        return computerMove;
    }
}
