package com.kodilla.sudoku;

import com.kodilla.sudoku.game.SudokuGame;

public class SudokuMain {
    public static void main(String[] args) throws CloneNotSupportedException{
        boolean gameFinished = false;
        while (!gameFinished){
            SudokuGame sudokuGame =  new SudokuGame();
            sudokuGame.run();
            gameFinished = sudokuGame.resolveSudoku();
        }
    }
}
