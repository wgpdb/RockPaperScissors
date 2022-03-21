package com.kodilla.rps;

import java.util.Random;

public class Computer {

    private int computerMoveEntry;
    private Move computerMove;

    public Move getComputerMove() {
        return computerMove;
    }

    public Move computerMove() {

        Random random = new Random();

        computerMoveEntry = random.nextInt(3) + 1;

        computerMove = GamePlay.moveSwitch(computerMoveEntry);

        return computerMove;
    }
}