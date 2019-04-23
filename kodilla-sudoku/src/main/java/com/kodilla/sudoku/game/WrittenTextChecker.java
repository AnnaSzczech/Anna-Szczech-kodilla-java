package com.kodilla.sudoku.game;

import com.kodilla.sudoku.game.Move;

public class WrittenTextChecker {
    private final String text;
    private Move move;

    public WrittenTextChecker(final String text) {
        this.text = text;
    }

    public boolean isTextCorrect() {

        if (isSizeIncorrect()) {
            return false;
        }

        return areComponentsCorrect();
    }

    private boolean isSudokuWritten() {
        return text.equalsIgnoreCase("SUDOKU");
    }

    private boolean isSizeIncorrect() {
        return text.length() != 5;
    }

    private boolean areComponentsCorrect() {
        try {
        setMove();
        return (isRangeCorrect(move.getCoordinateX(), move.getCoordinateY(), move.getNumber()));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void setMove() {
        String[] moveComponents = text.split(",");
        int coordinateX = getIntegerFromText(moveComponents[0]);
        int coordinateY = getIntegerFromText(moveComponents[1]);
        int value = getIntegerFromText(moveComponents[2]);
        move = new Move(coordinateX, coordinateY, value);
    }

    public int getIntegerFromText(String text) {
        return Integer.valueOf(text);
    }

    private boolean isRangeCorrect(int x, int y, int value) {
        return isRangeOfOneComponentCorrect(x) && isRangeOfOneComponentCorrect(y) && isRangeOfOneComponentCorrect(value);
    }

    private boolean isRangeOfOneComponentCorrect(int coordinate) {
        return coordinate >= 0 && coordinate <= 10;
    }

    public Move getMove() {
        return move;
    }
}

