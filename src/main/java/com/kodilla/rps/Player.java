package com.kodilla.rps;

import java.util.Scanner;

public class Player {

    private String playerName;
    private int playerMoveEntry;
    public Move playerMove;

    static Scanner scanner = new Scanner(System.in);

    public String getPlayerName() {
        return playerName;
    }

    public Move getPlayerMove() {
        return playerMove;
    }

    public void setPlayerName() {

        System.out.println("Enter player name:");
        playerName = scanner.next();
        scanner.nextLine();
    }

    public Move playerMove() {

        while (true) {
            System.out.println("\n" + getPlayerName() + ", select your move" + "\n" + "Enter 1 for rock, 2 for " +
                    "paper, 3 for scissors");

            try {
                playerMoveEntry = scanner.nextInt();
            } catch (Exception e) {
                throw new InvalidEntryException();
            } finally {
                scanner.nextLine();
            }

            if (playerMoveEntry == 1 || playerMoveEntry == 2 || playerMoveEntry == 3) {
                break;
            }
            System.out.println("\"" + playerMove + "\"" + " is not a valid move");
        }
        playerMove = GamePlay.moveSwitch(playerMoveEntry);

        return playerMove;
    }
}