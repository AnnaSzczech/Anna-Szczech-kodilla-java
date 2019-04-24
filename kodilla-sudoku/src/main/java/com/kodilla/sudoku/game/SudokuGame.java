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
        while (emptyField != 0 && !sudokuBoard.isWrongCreatedSudoku()) {
            fillTheSudokuBoard(sudokuBoard);
            emptyField = sudokuBoard.howManyEmptyFieldIsInBoard();
        }
    }

    private void fillTheSudokuBoard(SudokuBoard sudokuBoard) throws CloneNotSupportedException{
        System.out.println("Make move x,y,number");
        String moveText = scanner.next();
        MoveExecuter moveExecuter = new MoveExecuter(sudokuBoard, moveText);
        moveExecuter.makeMove();
    }

    public boolean resolveSudoku(){
        System.out.println("One more game? Y/N");
        String moveText = scanner.next();
        return !moveText.equalsIgnoreCase("Y");
    }
}