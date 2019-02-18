package com.kodilla.rps.game;

import com.kodilla.rps.movement.Move;
import com.kodilla.rps.movement.PlayerMove;
import com.kodilla.rps.movement.moves.Paper;
import com.kodilla.rps.movement.moves.Rock;
import com.kodilla.rps.movement.moves.Scissors;
import com.kodilla.rps.score.Round;
import com.kodilla.rps.score.ScoreBoard;

import java.util.Scanner;

public class Game {
    public static int counter = 0;
    private boolean end = false;
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
        System.out.println("Po ilu wygranych rundach następuje zwycięstwo,");
        numberOfRounds = Integer.parseInt(sc.nextLine());
        System.out.println("\nInformacja dot. klawiszy służących do obsługi gry:\n" +
                "    klawisz 1 - zagranie \"kamień\",\n" +
                "    klawisz 2 - zagranie \"papier\",\n" +
                "    klawisz 3 - zagranie \"nożyce\",\n" +
                "    klawisz x - zakończenie gry, poprzedzone pytaniem \"Czy na pewno zakończyć grę?\",\n" +
                "    klawisz n - uruchomienie gry od nowa, poprzedzone pytaniem \"Czy na pewno zakończyć aktualną grę?\",");
    }

    public void run(){
        printInformation();
        while (!end){
            newRound();
            System.out.println(name + " wykonaj ruch.");
            String move = sc.nextLine();
            readTheMove(move);
        }
    }

    public void readTheMove(String move){
        switch (move){
            case "1":
                makeMove(new Rock(Move.ROCK));
                break;
            case "2":
                makeMove(new Paper(Move.PAPER));
                break;
            case "3":
                makeMove(new Scissors(Move.SCISSORS));
                break;
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

    public void makeMove(PlayerMove playerMove){
        PlayerMove computerMove = drawComputerMove();
        scoreBoard.addRoundToBoard(new Round(playerMove, computerMove));
        if (scoreBoard.getResults().getPlayerPoints() >= numberOfRounds || scoreBoard.getResults().getComputerPoints() >= numberOfRounds){
            end = true;
            scoreBoard.printResults();
        }
    }

    public void exitTheGame(){
        System.out.println("Napewno chcesz zakończyć grę T/N?");
        String isEndOfTheGame = sc.nextLine();
        if (isEndOfTheGame.toUpperCase().substring(0, 1).equals("T")) {
            end = true;
            scoreBoard.printResults();
        } else {
            counter--;
        }
    }

    public void startNewGame(){
        System.out.println("Napewno chcesz rozpocząć nową grę T/N?");
        String isEndOfTheGame = sc.nextLine();
        if (isEndOfTheGame.toUpperCase().substring(0, 1).equals("T")) {
            counter = 0;
            scoreBoard.resetScoreBoard();
            printInformation();
        } else {
            counter--;
        }
    }

    public PlayerMove drawComputerMove(){
        int numberOdMove = (int) (Math.random()*3 + 1);
        switch (numberOdMove){
            case 1: return new Paper(Move.PAPER);
            case 2: return new Rock(Move.ROCK);
        }
        return new Scissors(Move.SCISSORS);
    }
}
