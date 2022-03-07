package com.kodilla.rps;

import java.util.Scanner;

public final class Player {

    private String playerName;
    private static int playerMove;

    public String getPlayerName() {
        return playerName;
    }

    public static int getPlayerMove() {
        return playerMove;
    }

    public void setPlayerName() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player name:");
        playerName = scanner.next();
    }

    public void setPlayerMove() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n" + getPlayerName() + ", select your move" + "\n" + "Enter 1 for rock, 2 for " +
                    "paper, 3 for scissors");
            playerMove = scanner.nextInt();

            if (playerMove == 1 || playerMove == 2 || playerMove == 3) {
                break;
            }
            System.out.println("\"" + playerMove + "\"" + " is not a valid move");
        }
    }
}