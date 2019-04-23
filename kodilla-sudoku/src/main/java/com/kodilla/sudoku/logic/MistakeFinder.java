package com.kodilla.sudoku.logic;

import com.kodilla.sudoku.game.Move;
import com.kodilla.sudoku.gui.SudokuRow;

import java.util.List;

public class MistakeFinder {
    public boolean findMistakeInThreeConditions(List<SudokuRow> boardGame, Move move) {
        int indexX = move.getCoordinateX() - 1;
        int indexY = move.getCoordinateY() - 1;
        int value = move.getNumber();
        return findMistakeInRow(boardGame.get(indexY), value) || findMistakeInColumn(boardGame, indexX, value) || findMistakeInMagicSquare(move, boardGame);
    }

    private boolean findMistakeInRow(SudokuRow sudokuRow, int value){
        return sudokuRow.getSudokuElementsInRow().stream()
                .anyMatch(sudokuElement -> sudokuElement.getValue() == value);
    }

    private boolean findMistakeInColumn(List<SudokuRow> boardGame, int indexX, int value){
        return boardGame.stream()
                .anyMatch(sudokuRow -> sudokuRow.getSudokuElementsInRow().get(indexX).getValue() == value);
    }

    private boolean findMistakeInMagicSquare(Move move, List<SudokuRow> boardGame){
        MagicSquare magicSquare = new MagicSquare();
        magicSquare.findCoordinateOfMagicSquare(move.getCoordinateX(), move.getCoordinateY());
        return magicSquare.getMagicSquareCoordinates().stream()
                .anyMatch(coordinates -> boardGame.get(coordinates.getCoordinateY()-1).getSudokuElementsInRow().get(coordinates.getCordinateX()-1).getValue() == move.getNumber());
    }
}
