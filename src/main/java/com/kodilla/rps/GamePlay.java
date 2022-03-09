package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class GamePlay {

    private int numberOfRounds;
    private int numberOfCompletedRounds;
    private String playerMoveName;
    private String computerMoveName;
    private int playerScore = 0;
    private int computerScore = 0;
    private boolean newGame;

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getNumberOfCompletedRounds() {
        numberOfCompletedRounds = playerScore + computerScore;
        return numberOfCompletedRounds;
    }

    public String getPlayerMoveName() {
        return playerMoveName;
    }

    public String getComputerMoveName() {
        return computerMoveName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public boolean isBreakOrExit() {
        return newGame;
    }

    public int setNumberOfRounds() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n" + "How many rounds would you like to play?");
            numberOfRounds = scanner.nextInt();

            if (numberOfRounds % 2 != 0 && numberOfRounds >= 1 && numberOfRounds <= 15) {
                 break;
            }
            System.out.println("\"" + numberOfRounds + "\"" + " is not a valid selection \n" +
                    "Please enter an odd number of rounds between 1 and 15");
        }

        if (numberOfRounds == 1) {
            System.out.println("You have selected " + numberOfRounds + " round");
        } else {
            System.out.println("You have selected " + numberOfRounds + " rounds");
        }
        return numberOfRounds;
    }

    public String setPlayerMoveName() {

        if (Player.getPlayerMove() == 1) {
            playerMoveName = "Rock";
        } else if (Player.getPlayerMove() == 2) {
            playerMoveName = "Paper";
        } else if (Player.getPlayerMove() == 3) {
            playerMoveName = "Scissors";
        }
        return playerMoveName;
    }

    public String setComputerMoveName() {

        if (Computer.getComputerMove() == 1) {
            computerMoveName = "Rock";
        } else if (Computer.getComputerMove() == 2) {
            computerMoveName = "Paper";
        } else if (Computer.getComputerMove() == 3) {
            computerMoveName = "Scissors";
        }
        return computerMoveName;
    }

    public void roundResult(int playerMove, int computerMove) {

        Map<Integer, Integer> winningCombinations = new HashMap<>();
        winningCombinations.put(1, 3);
        winningCombinations.put(2, 1);
        winningCombinations.put(3, 2);

        if (playerMove == computerMove) {
            System.out.println("It's a tie! \n");
        } else if (winningCombinations.get(playerMove) == computerMove) {
            System.out.println("You win! :-) \n");
            playerScore ++;
        } else {
            System.out.println("Computer wins! \n");
            computerScore ++;
        }
    }

    public void showScore(String playerName) {

        System.out.println("Score:" + "\n" + playerName + " : Computer - " + getPlayerScore() + " : "
                + getComputerScore());
    }

    public void resetScore() {

        playerScore -= getPlayerScore();
        computerScore -= getComputerScore();
    }

    public void winOrLoose(String playerName) {

        if (getComputerScore() < getPlayerScore()) {
            System.out.println("\n" + "Congratulations " + playerName + ", you win! :-)");
        } else {
            System.out.println("\n" + "Sorry " + playerName + ", you loose :-(");
        }
    }

    public void breakOrExit() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n" + "Select \"n\" to start a new game or \"e\" to exit");
            String newGameOrExit = scanner.next();

            if (newGameOrExit.equals("n")) {

                System.out.println("Are you sure you would like to start a new game? y/n");
                String confirmYesOrNo = scanner.next();

                if (confirmYesOrNo.equals("y")) {
                    newGame = true;
                    System.out.println("");
                    break;
                } else if (confirmYesOrNo.equals("n")) {
                    continue;
                }
                System.out.println("\"" + confirmYesOrNo + "\"" + " is not a valid selection");

            } else if (newGameOrExit.equals("e")) {

                System.out.println("Are you sure you would like to exit? y/n");
                String confirmYesOrNo = scanner.next();

                if (confirmYesOrNo.equals("y")) {
                    System.exit(0);
                } else if (confirmYesOrNo.equals("n")) {
                    continue;
                }
                System.out.println("\"" + confirmYesOrNo + "\"" + " is not a valid selection");
            }
            System.out.println("\"" + newGameOrExit + "\"" + " is not a valid selection");
        }
    }
}