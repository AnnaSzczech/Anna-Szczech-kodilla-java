package com.kodilla.sudoku.logic;

import com.kodilla.sudoku.game.Move;
import com.kodilla.sudoku.gui.SudokuRow;

import java.util.List;

public class PossibleValueRemover {
    private List<SudokuRow> boardGame;

    public PossibleValueRemover(List<SudokuRow> boardGame) {
        this.boardGame = boardGame;
    }

    public void remove(Move move) {
        SudokuRow sudokuRow = boardGame.get(move.getCoordinateY() - 1);
        sudokuRow.removePossibleValuesInWholeRow(move.getNumber());
        removeInWholeColumn(move.getNumber(), move.getCoordinateX() - 1);
        removeInMagicSquare(move);
    }

    private void removeInWholeColumn(int value, int columnIndex) {
        boardGame.stream().forEach(sudokuRow -> sudokuRow.getSudokuElementsInRow().get(columnIndex).removePossibleValuesInField(value));
    }

    private void removeInMagicSquare(Move move) {
        MagicSquare magicSquare = new MagicSquare();
        magicSquare.findCoordinateOfMagicSquare(move.getCoordinateX(), move.getCoordinateY());

        List<Coordinates> magicSquareCoordinates = magicSquare.getMagicSquareCoordinates();
        for (Coordinates coordinates : magicSquareCoordinates) {
            boardGame.get(coordinates.getCoordinateY() - 1).getSudokuElementsInRow().get(coordinates.getCordinateX() - 1).removePossibleValuesInField(move.getNumber());
        }
    }
}
