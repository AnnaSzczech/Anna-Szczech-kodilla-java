package com.kodilla.sudoku.gui;

import com.kodilla.sudoku.game.Move;
import com.kodilla.sudoku.logic.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuBoard extends Prototype {
    private List<SudokuRow> boardGame;
    private List<Backtrack> backtrackList;
    private boolean wrongCreatedSudoku = false;

    public boolean isWrongCreatedSudoku() {
        return wrongCreatedSudoku;
    }

    public SudokuBoard() {
        boardGame = new ArrayList<>();
        backtrackList = new ArrayList<>();
    }

    public void createSudokuRowsInBoard() {
        IntStream.iterate(1, n -> n + 1)
                .limit(9)
                .forEach(n -> boardGame.add(createSudokuRowWithEmptySudokuElements(n)));
    }

    private SudokuRow createSudokuRowWithEmptySudokuElements(int indexY) {
        SudokuRow sudokuRow = new SudokuRow();
        sudokuRow.createSudokuElementsInRow(indexY);
        return sudokuRow;
    }

    public List<SudokuRow> getSudokuRowsInBoard() {
        return boardGame;
    }

    public void changeValueInBoardIfPossible(Move move) {
        SudokuRow sudokuRow = boardGame.get(move.getCoordinateY() - 1);
        SudokuElement sudokuElement = sudokuRow.getSudokuElementsInRow().get(move.getCoordinateX() - 1);
        if (sudokuElement.getValue() == SudokuElement.EMPTY && sudokuElement.getPossibleValuesInField().contains(move.getNumber())) {
            putValueInBoard(sudokuElement, move.getNumber());
            changePossibleValues(sudokuElement);
        } else {
            System.out.println("The field is not empty or value cannot be put in this field!");
        }
    }

    private void removeFromPossibleValues(Move move) {
        PossibleValueRemover possibleValueRemover = new PossibleValueRemover(boardGame);
        possibleValueRemover.remove(move);
    }

    public void algorithm() throws CloneNotSupportedException {
        int emptyField = howManyEmptyFieldIsInBoard();
        while (emptyField != 0 && !wrongCreatedSudoku) {
            boolean somethingWasChangeInBoard = false;
            for (SudokuRow sudokuRow : boardGame) {
                for (SudokuElement sudokuElement : sudokuRow.getSudokuElementsInRow()) {
                    if (sudokuElement.getValue() == SudokuElement.EMPTY) {
                        int coordinateX = sudokuElement.getCoordinates().getCordinateX();
                        int coordinateY = sudokuElement.getCoordinates().getCoordinateY();
                        if (checkIfIsOnlyOnePossibleValue(sudokuElement)) {
                            int value = findFirstPossibleValue(sudokuElement);
                            if (checkIfGuessingWasWrong(new Move(coordinateX, coordinateY, value)) || value == 0 || sudokuElement.getPossibleValuesInField().size() == 0) {
                                error();
                                somethingWasChangeInBoard = false;
                                break;
                            } else {
                                somethingWasChangeInBoard = true;
                                putValueInBoard(sudokuElement, value);
                                changePossibleValues(sudokuElement);
                            }
                        } else {
                            OneFittingValue oneFittingValue = new OneFittingValue();
                            for (int value : sudokuElement.getPossibleValuesInField()) {
                                if (oneFittingValue.checkIfValueFitsOnlyInSelectedField(boardGame, new Move(coordinateX, coordinateY, value))) {
                                    somethingWasChangeInBoard = true;
                                    putValueInBoard(sudokuElement, value);
                                    changePossibleValues(sudokuElement);
                                    break;
                                }
                            }

                        }
                    }
                }
            }
            if (!somethingWasChangeInBoard) {
                guessingValue();
            }
            emptyField = howManyEmptyFieldIsInBoard();
            System.out.println(this.toString());
        }
    }


    private void putValueInBoard(SudokuElement sudokuElement, int value) {
        sudokuElement.setValue(value);
    }

    private void changePossibleValues(SudokuElement sudokuElement) {
        sudokuElement.removeAllPossibleValuesInField();
        int coordinateX = sudokuElement.getCoordinates().getCordinateX();
        int coordinateY = sudokuElement.getCoordinates().getCoordinateY();
        int value = sudokuElement.getValue();
        removeFromPossibleValues(new Move(coordinateX, coordinateY, value));
    }

    private boolean checkIfIsOnlyOnePossibleValue(SudokuElement sudokuElement) {
        return sudokuElement.getPossibleValuesInField().size() == 1;
    }

    private boolean checkIfGuessingWasWrong(Move move) {
        MistakeFinder mistakeFinder = new MistakeFinder();
        return mistakeFinder.findMistakeInThreeConditions(boardGame, move);
    }

    private int findFirstPossibleValue(SudokuElement sudokuElement) {
        return sudokuElement.getPossibleValuesInField().get(0);
    }

    public int howManyEmptyFieldIsInBoard() {
        return boardGame.stream()
                .flatMap(sudokuRow -> sudokuRow.getSudokuElementsInRow().stream())
                .filter(sudokuElement -> sudokuElement.getValue() == SudokuElement.EMPTY)
                .map(sudokuElement -> 1)
                .reduce(0, (sum, n) -> sum = sum + n);
    }

    public void fillBoardWithNumbers() {
        int emptyField = howManyEmptyFieldIsInBoard();
        while ((81 - emptyField) != 30) {
            int coordinateX = (int) (Math.random() * 9 + 1);
            int coordinateY = (int) (Math.random() * 9 + 1);
            int value = (int) (Math.random() * 9 + 1);
            changeValueInBoardIfPossible(new Move(coordinateX, coordinateY, value));
            emptyField = howManyEmptyFieldIsInBoard();
        }
    }

    public void guessingValue() throws CloneNotSupportedException {
        List<SudokuElement> emptySudokuElements = boardGame.stream()
                .flatMap(sudokuRow -> sudokuRow.getSudokuElementsInRow().stream())
                .filter(sudokuElement -> sudokuElement.getValue() == SudokuElement.EMPTY)
                .collect(Collectors.toList());
        boolean isError = emptySudokuElements.stream()
                .anyMatch(sudokuElement -> sudokuElement.getPossibleValuesInField().size() == 0);
        if (!isError) {
            int indexOfRolledSudokuElement = (int) (Math.random() * emptySudokuElements.size());
            SudokuElement rolledSudokuElement = emptySudokuElements.get(indexOfRolledSudokuElement);


            int rolledValue = rollValue(rolledSudokuElement);
            System.out.println("guess value: " + rolledValue + "  in field --> " + rolledSudokuElement.getCoordinates());
            SudokuBoard clonedSudokuBoard = deepCopy();

            Backtrack backtrack = new Backtrack(clonedSudokuBoard, rolledSudokuElement.getCoordinates(), rolledValue);
            backtrackList.add(backtrack);
            putValueInBoard(rolledSudokuElement, rolledValue);
            changePossibleValues(rolledSudokuElement);
        } else {
            error();
        }
    }

    private int rollValue(SudokuElement rolledSudokuElement) {
        int indexOfRolledValue = (int) (Math.random() * rolledSudokuElement.getPossibleValuesInField().size());
        return rolledSudokuElement.getPossibleValuesInField().get(indexOfRolledValue);
    }

    private void error() throws CloneNotSupportedException {
        System.out.println("Wrong guess!");
        if (backtrackList.size() == 0) {
            System.out.println("Wrong Sudoku values!");
            wrongCreatedSudoku = true;
        } else {
            Backtrack backtrack = backtrackList.get(backtrackList.size() - 1);
            int indexX = backtrack.getChoosenFieldCoordinates().getCordinateX() - 1;
            int indexY = backtrack.getChoosenFieldCoordinates().getCoordinateY() - 1;
            int value = backtrack.getChoosenFieldValue();
            toString();
            boardGame = backtrack.getSudokuBoard().boardGame;
            toString();

            SudokuElement sudokuElement = boardGame.get(indexY).getSudokuElementsInRow().get(indexX);
            int indexOfChosenValue = sudokuElement.getPossibleValuesInField().indexOf(value);
            sudokuElement.getPossibleValuesInField().remove(indexOfChosenValue);
            backtrackList.remove(backtrackList.size() - 1);
            SudokuBoard clonedSudokuBoard = deepCopy();
            int possibleValuesQuantity = sudokuElement.getPossibleValuesInField().size();
            if (possibleValuesQuantity > 0) {
                int newValue = sudokuElement.getPossibleValuesInField().get((int) (Math.random() * possibleValuesQuantity));
                backtrackList.add(new Backtrack(clonedSudokuBoard, sudokuElement.getCoordinates(), newValue));
                System.out.println("guess value: " + newValue + "  in field -->  " + sudokuElement.getCoordinates());
                putValueInBoard(sudokuElement, newValue);
                changePossibleValues(sudokuElement);
            }
        }
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard cloneSudokuBoard = (SudokuBoard) super.clone();
        cloneSudokuBoard.boardGame = new ArrayList<>();
        for (SudokuRow sudokuRow : boardGame) {
            SudokuRow cloneSudokuRow = new SudokuRow();
            for (SudokuElement sudokuElement : sudokuRow.getSudokuElementsInRow()) {
                SudokuElement cloneSudokuElement = new SudokuElement(new Coordinates(sudokuElement.getCoordinates().getCordinateX(), sudokuElement.getCoordinates().getCoordinateY()));
                cloneSudokuElement.setValue(sudokuElement.getValue());
                for (int possibleValues : sudokuElement.getPossibleValuesInField()) {
                    cloneSudokuElement.getPossibleValuesInField().add(possibleValues);
                }
                cloneSudokuRow.getSudokuElementsInRow().add(cloneSudokuElement);
            }
            cloneSudokuBoard.boardGame.add(cloneSudokuRow);
        }
        return cloneSudokuBoard;
    }

    public void printResult(){
        System.out.println(toString());
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
