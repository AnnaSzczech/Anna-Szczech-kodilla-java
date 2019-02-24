package com.kodilla.rps.game;

import com.kodilla.rps.movement.Move;
import com.kodilla.rps.movement.Player;
import com.kodilla.rps.score.Round;
import com.kodilla.rps.score.ScoreBoard;

import java.util.Scanner;
import java.util.function.Supplier;

public class Game {
    private int counter = 0;
    private boolean isTheEndOfTheGame = false;
    private int numberOfRounds;
    private String name;
    private ScoreBoard scoreBoard = new ScoreBoard();
    private Scanner sc = new Scanner(System.in);


    public void newRound(){
        counter++;
        System.out.println("\nRunda: " + counter);
    }

    public void printInformation(){
        System.out.println("Jak masz na imię?");
        name = sc.nextLine();
        howManyRounds();
        System.out.println("\nInformacja dot. klawiszy służących do obsługi gry:\n" +
                "    klawisz 1 - zagranie \"kamień\",\n" +
                "    klawisz 2 - zagranie \"papier\",\n" +
                "    klawisz 3 - zagranie \"nożyce\",\n" +
                "    klawisz x - zakończenie gry, poprzedzone pytaniem \"Czy na pewno zakończyć grę?\",\n" +
                "    klawisz n - uruchomienie gry od nowa, poprzedzone pytaniem \"Czy na pewno zakończyć aktualną grę?\",");
    }

    public void howManyRounds(){
        try {
            System.out.println("Po ilu wygranych rundach następuje zwycięstwo?");
            numberOfRounds = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawna liczba!");
            howManyRounds();
        }
    }

    public void run(){
        printInformation();
        while (!isTheEndOfTheGame){
            scoreBoard.printResults();
            newRound();
            System.out.println(name + " wykonaj ruch.");
            String move = sc.nextLine();
            readTheMove(move);
        }
    }

    public void readTheMove(String move){
        try {
            Runnable run = () -> makeMove(Move.returnSelectedMove(move));
            run.run();
        } catch (Exception e) {
            noMoveSelected(move);
        }
    }

    public void noMoveSelected(String move){
        switch (move) {
            case "x":
                exitTheGame();
                break;
            case "n":
                startNewGame();
                break;
            default:
                System.out.println("Wybrano niewłaściwy klawisz!");
                counter--;
        }
    }

    public void makeMove(Player userMove){
        Player computerMove = drawComputerMove();
        scoreBoard.addRoundToBoard(new Round(userMove, computerMove), counter);
        checkIfTheGameIsOver();
    }

    public void checkIfTheGameIsOver(){
        if (isUserWin() || isComputerWin()){
            isTheEndOfTheGame = true;
            scoreBoard.printHistoryOfGame();
        }
    }

    public boolean isUserWin(){
        return scoreBoard.getResults().getPlayerPoints() >= numberOfRounds;
    }

    public boolean isComputerWin(){
        return scoreBoard.getResults().getComputerPoints() >= numberOfRounds;
    }

    public void exitTheGame(){
        System.out.println("Napewno chcesz zakończyć grę T/N?");
        String isEndOfTheGame = sc.nextLine();
        if (isYes(isEndOfTheGame)) {
            isTheEndOfTheGame = true;
            scoreBoard.printResults();
        } else {
            counter--;
        }
    }

    public void startNewGame(){
        System.out.println("Napewno chcesz rozpocząć nową grę T/N?");
        String isEndOfTheGame = sc.nextLine();
        if (isYes(isEndOfTheGame)) {
            counter = 0;
            scoreBoard.startNewGame();
            printInformation();
        } else {
            counter--;
        }
    }

    public boolean isYes(String isEndOfTheGame){
        return isEndOfTheGame.substring(0, 1).equalsIgnoreCase("T");
    }

    public Player drawComputerMove(){
        int numberOdMove = (int) (Math.random()*3 + 1);
        Supplier supplier = () -> Move.returnSelectedMove(String.valueOf(numberOdMove));
        Player computerMove = (Player) supplier.get();
        return computerMove;
    }
}
