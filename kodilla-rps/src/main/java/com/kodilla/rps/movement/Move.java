package com.kodilla.rps.movement;

import com.kodilla.rps.movement.moves.Paper;
import com.kodilla.rps.movement.moves.Rock;
import com.kodilla.rps.movement.moves.Scissors;

import java.util.Arrays;

public enum Move {
    ROCK("1", new Rock()), PAPER("2", new Paper()), SCISSORS("3", new Scissors());

    private final String selectedMove;
    private final Player player;


    Move(final String selectedMove, final Player player){
        this.selectedMove = selectedMove;
        this.player = player;
    }

    public static Player returnSelectedMove(String selectedMove) {
        return Arrays.stream(values()).filter(move -> move.selectedMove.equals(selectedMove)).findFirst().get().player;
    }

    public String toString() {
        return super.toString().toLowerCase();
    }
}
