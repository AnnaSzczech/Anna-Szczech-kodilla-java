package com.kodilla.sudoku.game;

import com.kodilla.sudoku.gui.SudokuBoard;

public class MoveExecuter {
    private final SudokuBoard sudokuBoard;
    private final String moveText;

    public MoveExecuter(final SudokuBoard sudokuBoard, final String moveText) {
        this.sudokuBoard = sudokuBoard;
        this.moveText = moveText;
    }

    public void makeMove() throws CloneNotSupportedException {
        putMoveInBoard();
        useAlgorithmIfRequest();
    }

    private void putMoveInBoard() {
        WrittenTextChecker writtenTextChecker = new WrittenTextChecker(moveText);
        if (writtenTextChecker.isTextCorrect()) {
            Move move = writtenTextChecker.getMove();
            sudokuBoard.changeValueInBoardIfPossible(move);
            sudokuBoard.printResult();
        }
    }

    private void useAlgorithmIfRequest() throws CloneNotSupportedException {
        if (whetherToUseAlgorithm()) {
            sudokuBoard.algorithm();
        }
    }

    private boolean whetherToUseAlgorithm() {
        return moveText.equalsIgnoreCase("SUDOKU");
    }
}
