package com.kodilla.sudoku.game;

import com.kodilla.sudoku.gui.SudokuBoard;

import java.util.Scanner;

public class SudokuGame {
    private Scanner scanner;

    public SudokuGame(){
        scanner = new Scanner(System.in);
    }

    public void run() throws CloneNotSupportedException{
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createSudokuRowsInBoard();
        sudokuBoard.printResult();
        int emptyField = sudokuBoard.howManyEmptyFieldIsInBoard();
        while (emptyField != 0) {
            System.out.println("Make move x,y,number");
            String moveText = scanner.next();
            if (isSudokuWritten(moveText)){
                sudokuBoard.algorithm();
            } else {
                WrittenTextChecker writtenTextChecker = new WrittenTextChecker(moveText);
                if (writtenTextChecker.isTextCorrect()) {
                    Move move = writtenTextChecker.getMove();
                    sudokuBoard.changeValueInBoardIfPossible(move);
                    sudokuBoard.printResult();
                }
            }
            emptyField = sudokuBoard.howManyEmptyFieldIsInBoard();
        }
    }

    private boolean isSudokuWritten(String text){
        return text.equalsIgnoreCase("SUDOKU");
    }


    public boolean resolveSudoku(){
        System.out.println("One more game? Y/N");
        String moveText = scanner.next();
        return !moveText.equalsIgnoreCase("Y");
    }
}
