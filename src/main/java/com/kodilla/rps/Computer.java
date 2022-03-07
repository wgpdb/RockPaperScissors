package com.kodilla.rps;

import java.util.Random;

public final class Computer {

    private static int computerMove;

    public static int getComputerMove() {
        return computerMove;
    }

    public void setComputerMove() {

        Random moveGenerator = new Random();
        computerMove = moveGenerator.nextInt(3) + 1;
    }
}