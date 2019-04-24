package com.kodilla.sudoku;

import com.kodilla.sudoku.game.Move;
import com.kodilla.sudoku.gui.SudokuBoard;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuBoardTestSuite {
    private static int counter = 0;

    @Test
    public void testChangeValueInBoardIfNotPossible(){
        //given
        counter++;
        System.out.println("Test #" + counter + ": testChangeValueInBoardIfNotPossible.");
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createSudokuRowsInBoard();
        //when
        sudokuBoard.changeValueInBoardIfPossible(new Move(1,1,1));
        sudokuBoard.changeValueInBoardIfPossible(new Move(1,2,1));
        sudokuBoard.changeValueInBoardIfPossible(new Move(2,1,1));
        sudokuBoard.changeValueInBoardIfPossible(new Move(2,2,1));
        //then
        System.out.println(sudokuBoard.toString());
        int emptyField = sudokuBoard.howManyEmptyFieldIsInBoard();
        Assert.assertEquals(80, emptyField);
    }

    @Test
    public void testChangeValueInBoardIfPossible() {
        //given
        counter++;
        System.out.println("Test #" + counter + ": testChangeValueInBoardIfPossible.");
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createSudokuRowsInBoard();
        //when
        for (Move move : createEightRowsOfValues()) {
            sudokuBoard.changeValueInBoardIfPossible(move);
        }
        //then
        List<Integer> possibleValues = sudokuBoard.getSudokuRowsInBoard().stream()
                .flatMap(sudokuRow -> sudokuRow.getSudokuElementsInRow().stream())
                .filter(sudokuElement -> sudokuElement.getPossibleValuesInField().size() != 0)
                .flatMap(n -> n.getPossibleValuesInField().stream())
                .collect(Collectors.toList());
        System.out.println(sudokuBoard.toString());
        int emptyField = sudokuBoard.howManyEmptyFieldIsInBoard();
        Assert.assertEquals(9, emptyField);
        Assert.assertEquals(9, possibleValues.size());
    }

    @Test
    public void testAlgorithmWhenThereIsOnlyOnePossibleValue() throws CloneNotSupportedException{
        //given
        counter++;
        System.out.println("Test #" + counter + ": testAlgorithmWhenThereIsOnlyOnePossibleValue.");
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createSudokuRowsInBoard();
        //when
        for (Move move : createEightRowsOfValues()) {
            sudokuBoard.changeValueInBoardIfPossible(move);
        }
        //then
        System.out.println(sudokuBoard.toString());
        sudokuBoard.algorithm();
        System.out.println(sudokuBoard.toString());
        int emptyField = sudokuBoard.howManyEmptyFieldIsInBoard();
        Assert.assertEquals(0, emptyField);
    }

    @Test
    public void testAlgorithm() throws CloneNotSupportedException{
        //given
        counter++;
        System.out.println("Test #" + counter + ": testFillBoardWithNumbers.");
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createSudokuRowsInBoard();
        //when
        for (Move move : createSudokuBoard()) {
            sudokuBoard.changeValueInBoardIfPossible(move);
        }
        System.out.println(sudokuBoard.toString());
        sudokuBoard.algorithm();
        //then
        int emptyField = sudokuBoard.howManyEmptyFieldIsInBoard();
        Assert.assertEquals(0, emptyField);
    }

    @Test
    public void testFillBoardWithNumbers() throws CloneNotSupportedException{
        //given
        counter++;
        System.out.println("Test #" + counter + ": testFillBoardWithNumbers.");
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createSudokuRowsInBoard();
        //when
        sudokuBoard.fillBoardWithNumbers();
        System.out.println(sudokuBoard.toString());
        sudokuBoard.algorithm();
        //then
        int emptyField = sudokuBoard.howManyEmptyFieldIsInBoard();
        sudokuBoard.toString();
        if (emptyField != 0){
            Assert.assertTrue(sudokuBoard.isWrongCreatedSudoku());
        }
    }



    // VALUES IN BOARD

    private List<Move> createEightRowsOfValues() {
        List<Move> elementsInEightRow = new ArrayList<>();
        elementsInEightRow.addAll(createFirstRowInBoard());
        elementsInEightRow.addAll(createSecondRowInBoard());
        elementsInEightRow.addAll(createThirdRowInBoard());
        elementsInEightRow.addAll(createFifthRowInBoard());
        elementsInEightRow.addAll(createSixthRowInBoard());
        elementsInEightRow.addAll(createSeventhRowInBoard());
        elementsInEightRow.addAll(createEighthRowInBoard());
        elementsInEightRow.addAll(createNinthRowInBoard());
        return elementsInEightRow;
    }

    private List<Move> createFirstRowInBoard() {
        List<Move> elementsInFirstRow = new ArrayList<>();
        elementsInFirstRow.add(new Move(1, 1, 4));
        elementsInFirstRow.add(new Move(2, 1, 2));
        elementsInFirstRow.add(new Move(3, 1, 6));
        elementsInFirstRow.add(new Move(4, 1, 5));
        elementsInFirstRow.add(new Move(5, 1, 7));
        elementsInFirstRow.add(new Move(6, 1, 1));
        elementsInFirstRow.add(new Move(7, 1, 3));
        elementsInFirstRow.add(new Move(8, 1, 9));
        elementsInFirstRow.add(new Move(9, 1, 8));
        return elementsInFirstRow;
    }

    private List<Move> createSecondRowInBoard() {
        List<Move> elementsInSecondRow = new ArrayList<>();
        elementsInSecondRow.add(new Move(1, 2, 8));
        elementsInSecondRow.add(new Move(2, 2, 5));
        elementsInSecondRow.add(new Move(3, 2, 7));
        elementsInSecondRow.add(new Move(4, 2, 2));
        elementsInSecondRow.add(new Move(5, 2, 9));
        elementsInSecondRow.add(new Move(6, 2, 3));
        elementsInSecondRow.add(new Move(7, 2, 1));
        elementsInSecondRow.add(new Move(8, 2, 4));
        elementsInSecondRow.add(new Move(9, 2, 6));
        return elementsInSecondRow;
    }

    private List<Move> createThirdRowInBoard() {
        List<Move> elementsInThirdRow = new ArrayList<>();
        elementsInThirdRow.add(new Move(1, 3, 1));
        elementsInThirdRow.add(new Move(2, 3, 3));
        elementsInThirdRow.add(new Move(3, 3, 9));
        elementsInThirdRow.add(new Move(4, 3, 4));
        elementsInThirdRow.add(new Move(5, 3, 6));
        elementsInThirdRow.add(new Move(6, 3, 8));
        elementsInThirdRow.add(new Move(7, 3, 2));
        elementsInThirdRow.add(new Move(8, 3, 7));
        elementsInThirdRow.add(new Move(9, 3, 5));
        return elementsInThirdRow;
    }

    private List<Move> createFourthRowInBoard() {
        List<Move> elementsInFourthRow = new ArrayList<>();
        elementsInFourthRow.add(new Move(1, 4, 9));
        elementsInFourthRow.add(new Move(2, 4, 7));
        elementsInFourthRow.add(new Move(3, 4, 1));
        elementsInFourthRow.add(new Move(4, 4, 3));
        elementsInFourthRow.add(new Move(5, 4, 8));
        elementsInFourthRow.add(new Move(6, 4, 5));
        elementsInFourthRow.add(new Move(7, 4, 6));
        elementsInFourthRow.add(new Move(8, 4, 2));
        elementsInFourthRow.add(new Move(9, 4, 4));
        return elementsInFourthRow;
    }

    private List<Move> createFifthRowInBoard() {
        List<Move> elementsInFifthRow = new ArrayList<>();
        elementsInFifthRow.add(new Move(1, 5, 5));
        elementsInFifthRow.add(new Move(2, 5, 4));
        elementsInFifthRow.add(new Move(3, 5, 3));
        elementsInFifthRow.add(new Move(4, 5, 7));
        elementsInFifthRow.add(new Move(5, 5, 2));
        elementsInFifthRow.add(new Move(6, 5, 6));
        elementsInFifthRow.add(new Move(7, 5, 8));
        elementsInFifthRow.add(new Move(8, 5, 1));
        elementsInFifthRow.add(new Move(9, 5, 9));
        return elementsInFifthRow;
    }

    private List<Move> createSixthRowInBoard() {
        List<Move> elementsInSixthRow = new ArrayList<>();
        elementsInSixthRow.add(new Move(1, 6, 6));
        elementsInSixthRow.add(new Move(2, 6, 8));
        elementsInSixthRow.add(new Move(3, 6, 2));
        elementsInSixthRow.add(new Move(4, 6, 1));
        elementsInSixthRow.add(new Move(5, 6, 4));
        elementsInSixthRow.add(new Move(6, 6, 9));
        elementsInSixthRow.add(new Move(7, 6, 7));
        elementsInSixthRow.add(new Move(8, 6, 5));
        elementsInSixthRow.add(new Move(9, 6, 3));
        return elementsInSixthRow;
    }

    private List<Move> createSeventhRowInBoard() {
        List<Move> elementsInSeventhRow = new ArrayList<>();
        elementsInSeventhRow.add(new Move(1, 7, 7));
        elementsInSeventhRow.add(new Move(2, 7, 9));
        elementsInSeventhRow.add(new Move(3, 7, 4));
        elementsInSeventhRow.add(new Move(4, 7, 6));
        elementsInSeventhRow.add(new Move(5, 7, 3));
        elementsInSeventhRow.add(new Move(6, 7, 2));
        elementsInSeventhRow.add(new Move(7, 7, 5));
        elementsInSeventhRow.add(new Move(8, 7, 8));
        elementsInSeventhRow.add(new Move(9, 7, 1));
        return elementsInSeventhRow;
    }

    private List<Move> createEighthRowInBoard() {
        List<Move> elementsInEighthRow = new ArrayList<>();
        elementsInEighthRow.add(new Move(1, 8, 2));
        elementsInEighthRow.add(new Move(2, 8, 6));
        elementsInEighthRow.add(new Move(3, 8, 5));
        elementsInEighthRow.add(new Move(4, 8, 8));
        elementsInEighthRow.add(new Move(5, 8, 1));
        elementsInEighthRow.add(new Move(6, 8, 4));
        elementsInEighthRow.add(new Move(7, 8, 9));
        elementsInEighthRow.add(new Move(8, 8, 3));
        elementsInEighthRow.add(new Move(9, 8, 7));
        return elementsInEighthRow;
    }

    private List<Move> createNinthRowInBoard() {
        List<Move> elementsInNinthRow = new ArrayList<>();
        elementsInNinthRow.add(new Move(1, 9, 3));
        elementsInNinthRow.add(new Move(2, 9, 1));
        elementsInNinthRow.add(new Move(3, 9, 8));
        elementsInNinthRow.add(new Move(4, 9, 9));
        elementsInNinthRow.add(new Move(5, 9, 5));
        elementsInNinthRow.add(new Move(6, 9, 7));
        elementsInNinthRow.add(new Move(7, 9, 4));
        elementsInNinthRow.add(new Move(8, 9, 6));
        elementsInNinthRow.add(new Move(9, 9, 2));
        return elementsInNinthRow;
    }

    private List<Move> createSudokuBoard() {
        List<Move> elementsInBoard = new ArrayList<>();
        elementsInBoard.add(new Move(2, 1, 2));
        elementsInBoard.add(new Move(4, 1, 5));
        elementsInBoard.add(new Move(6, 1, 1));
        elementsInBoard.add(new Move(8, 1, 9));
        elementsInBoard.add(new Move(1, 2, 8));
        elementsInBoard.add(new Move(4, 2, 2));
        elementsInBoard.add(new Move(6, 2, 3));
        elementsInBoard.add(new Move(9, 2, 6));
        elementsInBoard.add(new Move(2, 3, 3));
        elementsInBoard.add(new Move(5, 3, 6));
        elementsInBoard.add(new Move(8, 3, 7));
        elementsInBoard.add(new Move(3, 4, 1));
        elementsInBoard.add(new Move(7, 4, 6));
        elementsInBoard.add(new Move(1, 5, 5));
        elementsInBoard.add(new Move(2, 5, 4));
        elementsInBoard.add(new Move(8, 5, 1));
        elementsInBoard.add(new Move(9, 5, 9));
        elementsInBoard.add(new Move(3, 6, 2));
        elementsInBoard.add(new Move(7, 6, 7));
        elementsInBoard.add(new Move(2, 7, 9));
        elementsInBoard.add(new Move(5, 7, 3));
        elementsInBoard.add(new Move(8, 7, 8));
        elementsInBoard.add(new Move(1, 8, 2));
        elementsInBoard.add(new Move(4, 8, 8));
        elementsInBoard.add(new Move(6, 8, 4));
        elementsInBoard.add(new Move(9, 8, 7));
        elementsInBoard.add(new Move(2, 9, 1));
        elementsInBoard.add(new Move(4, 9, 9));
        elementsInBoard.add(new Move(6, 9, 7));
        elementsInBoard.add(new Move(8, 9, 6));
        return elementsInBoard;
    }
}
