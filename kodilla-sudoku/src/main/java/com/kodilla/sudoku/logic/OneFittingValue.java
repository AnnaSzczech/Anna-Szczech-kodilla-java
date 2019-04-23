package com.kodilla.sudoku.logic;

import com.kodilla.sudoku.game.Move;
import com.kodilla.sudoku.gui.SudokuElement;
import com.kodilla.sudoku.gui.SudokuRow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OneFittingValue {

    public boolean checkIfValueFitsOnlyInSelectedField(List<SudokuRow> boardGame, Move move) {
        boolean result = false;
        if (checkThreeConditions(boardGame, move)) {
            result = true;
        }
        return result;
    }

    private boolean checkThreeConditions(List<SudokuRow> boardGame, Move move) {
        int indexX = move.getCoordinateX() - 1;
        int indexY = move.getCoordinateY() - 1;
        int value = move.getNumber();
        return checkInRow(boardGame.get(indexY), value, indexX) || checkInColumn(boardGame, indexX, indexY, value) || checkInMagicSquare(move, boardGame);
    }

    private boolean checkInRow(SudokuRow sudokuRow, int value, int indexX) {
        List<SudokuElement> newSudokuRow = copySudokuRow(sudokuRow, indexX);
        boolean result = !(newSudokuRow.stream()
                .flatMap(sudokuElement -> sudokuElement.getPossibleValuesInField().stream())
                .anyMatch(possibleValue -> possibleValue.equals(value)));
        return result;
    }

    private List<SudokuElement> copySudokuRow(SudokuRow sudokuRow, int coordinateX) {
        List<SudokuElement> newSudokuRow = new ArrayList<>();
        for (SudokuElement sudokuElement : sudokuRow.getSudokuElementsInRow()) {
            newSudokuRow.add(sudokuElement);
        }
        newSudokuRow.remove(coordinateX);
        return newSudokuRow;
    }

    private boolean checkInColumn(List<SudokuRow> boardGame, int indexX, int indexY, int value) {
        int y = 0;
        for (SudokuRow sudokuRow : boardGame) {
            if (y != indexY) {
                List<Integer> values = sudokuRow.getSudokuElementsInRow().get(indexX).getPossibleValuesInField();
                if (isValueInListOfPossibleValues(value, values)) {
                    return false;
                }
            }
            y++;
        }
        return true;
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
        if (isValueInListOfPossibleValues(move.getNumber(), values)) {
            return false;
        }
        return true;
    }
}
