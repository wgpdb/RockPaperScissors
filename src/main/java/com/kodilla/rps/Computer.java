package com.kodilla.rps;

import java.util.Random;

public class Computer {

    private int computerMoveEntry;
    private GamePlay.Move computerMove;

    public GamePlay.Move getComputerMove() {
        return computerMove;
    }

    public GamePlay.Move computerMove() {

        Random random = new Random();

        computerMoveEntry = random.nextInt(3) + 1;

        switch (computerMoveEntry) {
            case 1 : return computerMove = GamePlay.Move.ROCK;
            case 2 : return computerMove = GamePlay.Move.PAPER;
            case 3 : return computerMove = GamePlay.Move.SCISSORS;
        }
        return computerMove;
    }
}