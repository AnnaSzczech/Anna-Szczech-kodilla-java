package com.kodilla.sudoku.game;

import com.kodilla.sudoku.gui.SudokuBoard;

import java.util.List;
import java.util.Scanner;

public class SudokuGame {
    private Scanner scanner;

    public SudokuGame(){
        scanner = new Scanner(System.in);
    }

    public void run(){
        System.out.println("Make move x,y,number");
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createSudokuRowsInBoard();
        for (int i =0; i<2; i++) {
            String moveText = scanner.next();
            Move move = changeTextIntoMove(moveText);
            sudokuBoard.changeValueInBoardIfPossible(move);
            System.out.println(sudokuBoard);
        }
    }

    public Move changeTextIntoMove(String text){
        String[] textSeparateForInt = text.split(",");
        int coordinateX = getIntegerFromText(textSeparateForInt[0]);
        int coordinateY = getIntegerFromText(textSeparateForInt[1]);
        int number = getIntegerFromText(textSeparateForInt[2]);
        return new Move(coordinateX, coordinateY, number);
    }

    public int getIntegerFromText(String text){
        return Integer.valueOf(text);
    }

    public boolean resolveSudoku(){
        // będzie zwracała informację o tym czy użytkownik chce zrealizować kolejne Sudoku (wówczas zwraca true) lub zakończyć pracę z programem (wówczas zwraca false).
        return true;
    }
}
