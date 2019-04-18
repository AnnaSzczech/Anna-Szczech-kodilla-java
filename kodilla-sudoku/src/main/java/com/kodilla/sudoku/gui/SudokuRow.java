package com.kodilla.sudoku.gui;

import com.kodilla.sudoku.gui.SudokuElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuRow {
    private final List<SudokuElement> sudokuElementsInRow;

    public SudokuRow(){
        sudokuElementsInRow = new ArrayList<>();
    }

    public void createSudokuElementsInRow(){
        IntStream.iterate(1, n -> n+1)
                .limit(9)
                .forEach(n -> sudokuElementsInRow.add(createEmptySudokuElement()));
    }

    private SudokuElement createEmptySudokuElement(){
        SudokuElement sudokuElement = new SudokuElement();
        sudokuElement.createPossibleValuesCollection();
        return sudokuElement;
    }

    public List<SudokuElement> getSudokuElementsInRow(){
        return sudokuElementsInRow;
    }

    public void removePossibleValuesInWholeRow(int value){
        sudokuElementsInRow.stream()
                .forEach(sudokuElement -> sudokuElement.removePossibleValuesInField(value));
    }
}
