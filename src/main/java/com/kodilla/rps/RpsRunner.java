package com.kodilla.rps;

public class RpsRunner {

    public static void main(String[] args) {

        boolean end = false;

        Player player = new Player();
        Computer computer = new Computer();
        GamePlay gamePlay = new GamePlay();

        System.out.println("<<< ROCK | PAPER | SCISSORS >>>" + "\n");

        while (!end) {

            player.setPlayerName();
            System.out.println("Player name is: " + player.getPlayerName());

            while (true) {

                try {
                    gamePlay.setNumberOfRounds();
                } catch (InvalidEntryException e) {
                    System.out.println("Invalid entry");
                    continue;
                }

                while (true) {

                    try {
                        player.playerMove();
                    } catch (InvalidEntryException e) {
                        System.out.println("Invalid entry");
                        continue;
                    }

                    System.out.println(player.getPlayerName() + " selected " + player.getPlayerMove());

                    computer.computerMove();

                    System.out.println("Computer selected " + computer.getComputerMove());

                    gamePlay.roundResult(player.getPlayerMove(), computer.getComputerMove());

                    gamePlay.showScore(player.getPlayerName());

                    if (gamePlay.getNumberOfRounds() == gamePlay.getNumberOfCompletedRounds()) {
                        gamePlay.winOrLoose(player.getPlayerName());
                        break;
                    }
                }

                gamePlay.breakOrExit();

                if (gamePlay.isBreakOrExit()) {
                    gamePlay.resetScore();
                    break;
                }
            }
        }
    }
}