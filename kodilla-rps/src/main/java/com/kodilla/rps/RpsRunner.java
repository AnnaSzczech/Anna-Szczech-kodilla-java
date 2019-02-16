package com.kodilla.rps;

import com.kodilla.rps.movement.Movements;
import com.kodilla.rps.movement.moves.Paper;

public class RpsRunner {
    public static void main(String[] args) {
        Paper paper = new Paper(Movements.PAPER);
        System.out.println(paper.getMovements());
    }
}
