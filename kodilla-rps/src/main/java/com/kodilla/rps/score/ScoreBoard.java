package com.kodilla.rps.score;

import com.kodilla.rps.game.Game;
import com.kodilla.rps.movement.Move;
import com.kodilla.rps.movement.PlayerMove;

import java.util.HashMap;
import java.util.Map;

public final class ScoreBoard {
    private final Map<Integer, Round> listOfRounds = new HashMap<>();
    Points results = new Points();

    public void addRoundToBoard(Round roundResult){
        listOfRounds.put(Game.counter, roundResult);
        Move playerMove = roundResult.getPlayerMove().getMove();
        Move computerMove = roundResult.getComputerMove().getMove();
        System.out.println("player, " + playerMove + " : computer, " + computerMove);
        if (!playerMove.equals(computerMove)) {
            setThePoint(roundResult.getPlayerMove(), roundResult.getComputerMove());
        }
    }

    public void setThePoint(PlayerMove playerMove, PlayerMove computerMove){
        if (playerMove.isSuccessful(computerMove.getMove())){
            results.addPointsToPlayer();
        } else {
            results.addPointsToComputer();
        }
    }

    public void resetScoreBoard(){
        results.resetPoints();
        listOfRounds.clear();
    }

    public void printResults(){
        System.out.println("\n" + results);
        for (Map.Entry<Integer, Round> round : listOfRounds.entrySet()) {
            System.out.println(round.getKey() + ". " + round.getValue());
        }
    }

    public HashMap<Integer, Round> getListOfRounds() {
        return new HashMap<>(listOfRounds);
    }

    public Points getResults() {
        return results;
    }

}
