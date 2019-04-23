package com.kodilla.sudoku.logic;

import com.kodilla.sudoku.gui.SudokuBoard;

public class Backtrack {
    private SudokuBoard sudokuBoard;
    private Coordinates choosenFieldCoordinates;
    private int choosenFieldValue;

    public Backtrack(SudokuBoard sudokuBoard, Coordinates choosenFieldCoordinates, int choosenFieldValue) {
        this.sudokuBoard = sudokuBoard;
        this.choosenFieldCoordinates = choosenFieldCoordinates;
        this.choosenFieldValue = choosenFieldValue;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public Coordinates getChoosenFieldCoordinates() {
        return choosenFieldCoordinates;
    }

    public int getChoosenFieldValue() {
        return choosenFieldValue;
    }
}
