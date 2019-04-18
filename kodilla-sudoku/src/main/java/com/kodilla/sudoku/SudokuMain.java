package com.kodilla.sudoku;

import com.kodilla.sudoku.game.SudokuGame;

public class SudokuMain {
    public static void main(String[] args) {

//        boolean gameFinished = false;
//        while (!gameFinished){
//            //tyle razy ile gracz chce wykonywac nowe sudoku
            SudokuGame sudokuGame =  new SudokuGame();
            sudokuGame.run();
//
//
//
//
//            gameFinished = sudokuGame.resolveSudoku();
//        }
    }
}
