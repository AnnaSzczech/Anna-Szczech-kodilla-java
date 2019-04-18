package com.kodilla.sudoku.gui;

import com.kodilla.sudoku.game.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuBoard {
    private final List<SudokuRow> boardGame;

    public SudokuBoard() {
        boardGame = new ArrayList<>();
    }

    public void createSudokuRowsInBoard() {
        IntStream.iterate(1, n -> n + 1)
                .limit(9)
                .forEach(n -> boardGame.add(createSudokuRowWithEmptySudokuElements()));
    }

    private SudokuRow createSudokuRowWithEmptySudokuElements() {
        SudokuRow sudokuRow = new SudokuRow();
        sudokuRow.createSudokuElementsInRow();
        return sudokuRow;
    }

    public List<SudokuRow> getSudokuRowsInBoard() {
        return boardGame;
    }

    public void changeValueInBoardIfPossible(Move move) {
        SudokuRow sudokuRow = boardGame.get(move.getCoordinateY() - 1);
        SudokuElement sudokuElement = sudokuRow.getSudokuElementsInRow().get(move.getCoordinateX() - 1);
        if (sudokuElement.getValue() == SudokuElement.EMPTY && sudokuElement.getPossibleValuesInField().contains(move.getNumber())) {
            sudokuElement.setValue(move.getNumber());
            removeSelectedNumberFromPossibleValuesInField(sudokuRow, move);
        }
    }

    private void removeSelectedNumberFromPossibleValuesInField(SudokuRow sudokuRow, Move move){
        sudokuRow.removePossibleValuesInWholeRow(move.getNumber());
        removeInWholeColumn(move.getNumber(), move.getCoordinateX() - 1);
        removeInMagicSquare(move);
    }

    private void removeInWholeColumn(int value, int columnIndex) {
        boardGame.stream().forEach(sudokuRow -> sudokuRow.getSudokuElementsInRow().get(columnIndex).removePossibleValuesInField(value));
    }

    private void removeInMagicSquare(Move move) {
        int indexX1 = getIndexOfMagicSquare(move.getCoordinateX())[0]-1;
        int indexX2 = getIndexOfMagicSquare(move.getCoordinateX())[1]-1;
        int indexY1 = getIndexOfMagicSquare(move.getCoordinateY())[0]-1;
        int indexY2 = getIndexOfMagicSquare(move.getCoordinateY())[1]-1;
        boardGame.get(indexY1).getSudokuElementsInRow().get(indexX1).removePossibleValuesInField(move.getNumber());
        boardGame.get(indexY1).getSudokuElementsInRow().get(indexX2).removePossibleValuesInField(move.getNumber());
        boardGame.get(indexY2).getSudokuElementsInRow().get(indexX1).removePossibleValuesInField(move.getNumber());
        boardGame.get(indexY2).getSudokuElementsInRow().get(indexX2).removePossibleValuesInField(move.getNumber());
    }

    private int[] getIndexOfMagicSquare(int indexOfNumber) {
        int index1, index2;
        if (indexOfNumber % 3 == 0) {
            index1 = indexOfNumber - 1;
            index2 = indexOfNumber - 2;
            return new int[]{index1, index2};
        } else if (indexOfNumber % 3 == 1) {
            index1 = indexOfNumber + 1;
            index2 = indexOfNumber + 2;
            return new int[]{index1, index2};
        } else {
            index1 = indexOfNumber - 1;
            index2 = indexOfNumber + 1;
            return new int[]{index1, index2};
        }
    }

    @Override
    public String toString() {
        String result = " -----------------------------------\n|";
        for (SudokuRow singleRow : boardGame) {
            for (SudokuElement sudokuElement : singleRow.getSudokuElementsInRow()) {
                if (sudokuElement.getValue() == SudokuElement.EMPTY) {
                    result += "   ";
                } else {
                    result += " " + sudokuElement.getValue() + " ";
                }
                result += "|";
            }
            result += "\n -----------------------------------\n|";
        }
        return result;
    }
}
