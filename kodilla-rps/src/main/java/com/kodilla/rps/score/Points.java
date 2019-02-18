package com.kodilla.rps.score;

public class Points {
    private int computerPoints = 0;
    private int playerPoints = 0;

    public void addPointsToComputer(){
        computerPoints++;
    }

    public void addPointsToPlayer(){
        playerPoints++;
    }

    public void resetPoints(){
        computerPoints = 0;
        playerPoints = 0;
    }

    public int getComputerPoints() {
        return computerPoints;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    @Override
    public String toString() {
        return "Punkty gracza : Punkty komputera\n" +
                 "        " + playerPoints + "     :      " + computerPoints;
    }
}
