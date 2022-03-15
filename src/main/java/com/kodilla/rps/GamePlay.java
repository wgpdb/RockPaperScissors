package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;

import static com.kodilla.rps.Player.scanner;

public class GamePlay {

    public int numberOfRounds;
    private int playerScore = 0;
    private int computerScore = 0;
    private boolean newGame;

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getNumberOfCompletedRounds() {
        return playerScore + computerScore;
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

    public enum Move {
        ROCK, PAPER, SCISSORS
    }

    public int setNumberOfRounds() throws InvalidEntryException {

        while (true) {

            System.out.println("\n" + "How many rounds would you like to play?");

            try {
                numberOfRounds = scanner.nextInt();
            } catch (Exception e) {
                throw new InvalidEntryException();
            } finally {
                scanner.nextLine();
            }

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

    public void roundResult(Move playerMove, Move computerMove) {

        Map<Move, Move> winningCombinations = new HashMap<>();
        winningCombinations.put(Move.ROCK, Move.SCISSORS);
        winningCombinations.put(Move.PAPER, Move.ROCK);
        winningCombinations.put(Move.SCISSORS, Move.PAPER);

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

        while (true) {

            System.out.println("\n" + "Select \"n\" to start a new game or \"e\" to exit");
            String newGameOrExit = scanner.nextLine();

            if (newGameOrExit.equals("n")) {

                System.out.println("Are you sure you would like to start a new game? y/n");
                String confirmYesOrNo = scanner.nextLine();

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
                String confirmYesOrNo = scanner.nextLine();

                if (confirmYesOrNo.equals("y")) {
                    System.exit(0);
                } else if (confirmYesOrNo.equals("n")) {
                    continue;
                }
                System.out.println("\"" + confirmYesOrNo + "\"" + " is not a valid selection");
            }
            System.out.println("\"" + newGameOrExit + "\"" + " is not a valid selection");
            Player.scanner.next();
        }
    }
}