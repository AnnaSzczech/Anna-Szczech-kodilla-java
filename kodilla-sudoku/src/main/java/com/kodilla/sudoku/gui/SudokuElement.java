package com.kodilla.sudoku.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuElement {
    public static final int EMPTY = -1;
    private int value;
    private List<Integer> possibleValuesInField;

    public SudokuElement(){
        value = EMPTY;
    }

    public void createPossibleValuesCollection(){
        possibleValuesInField = new ArrayList<>();
        IntStream.iterate(1, n -> n+1)
                .limit(9)
                .forEach(n -> possibleValuesInField.add(n));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int number) {
        value = number;
    }

    public List<Integer> getPossibleValuesInField() {
        return possibleValuesInField;
    }

    public void removePossibleValuesInField(int value){
        if (isValueInTheList(value)) {
            int index = possibleValuesInField.indexOf(value);
            possibleValuesInField.remove(index);
        }
    }

    private boolean isValueInTheList(int value){
        return possibleValuesInField.contains(value);
    }
}
