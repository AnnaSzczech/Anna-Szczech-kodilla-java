package com.kodilla.sudoku.logic;

import com.kodilla.sudoku.game.Move;
import com.kodilla.sudoku.gui.SudokuRow;

import java.util.ArrayList;
import java.util.List;

public class OneFittingValue {

    public boolean checkIfValueFitsOnlyInSelectedField(List<SudokuRow> boardGame, Move move) {
        return (checkThreeConditions(boardGame, move));
    }

    private boolean checkThreeConditions(List<SudokuRow> boardGame, Move move) {
        int indexX = move.getCoordinateX() - 1;
        int indexY = move.getCoordinateY() - 1;
        int value = move.getNumber();
        return checkInRow(boardGame.get(indexY), value, indexX) || checkInColumn(boardGame, indexX, indexY, value) || checkInMagicSquare(move, boardGame);
    }

    private boolean checkInRow(SudokuRow sudokuRow, int value, int indexX) {
        boolean result = !(sudokuRow.getSudokuElementsInRow().stream()
                .filter(sudokuElement -> sudokuElement.getCoordinates().getCordinateX() != indexX + 1)
                .flatMap(sudokuElement -> sudokuElement.getPossibleValuesInField().stream())
                .anyMatch(possibleValue -> possibleValue.equals(value)));
        return result;
    }

    private boolean checkInColumn(List<SudokuRow> boardGame, int indexX, int indexY, int value) {
        return !boardGame.stream()
                .anyMatch(sudokuRow -> isValueInListOfPossibleValues(value, getListOfPossibleValuesFromSudokuElemet(sudokuRow, indexX)) && ( getIndexYFromSudokuElemet(sudokuRow, indexX) != indexY));
    }

    private List<Integer> getListOfPossibleValuesFromSudokuElemet(SudokuRow sudokuRow, int indexX) {
        return sudokuRow.getSudokuElementsInRow().get(indexX).getPossibleValuesInField();
    }

    private int getIndexYFromSudokuElemet(SudokuRow sudokuRow, int indexX) {
        return sudokuRow.getSudokuElementsInRow().get(indexX).getCoordinates().getCoordinateY() - 1;
    }

    private boolean isValueInListOfPossibleValues(int value, List<Integer> values) {
        for (int number : values) {
            if (number == value) {
                return true;
            }
        }
        return false;
    }

    private boolean checkInMagicSquare(Move move, List<SudokuRow> boardGame) {

        MagicSquare magicSquare = new MagicSquare();
        magicSquare.findCoordinateOfMagicSquare(move.getCoordinateX(), move.getCoordinateY());
        List<Coordinates> magicSquareCoordinates = magicSquare.getMagicSquareCoordinates();
        List<Integer> values = new ArrayList<>();
        for (Coordinates coordinates : magicSquareCoordinates) {
            values.addAll(boardGame.get(coordinates.getCoordinateY() - 1).getSudokuElementsInRow().get(coordinates.getCordinateX() - 1).getPossibleValuesInField());
        }
        return !(isValueInListOfPossibleValues(move.getNumber(), values));
    }
}