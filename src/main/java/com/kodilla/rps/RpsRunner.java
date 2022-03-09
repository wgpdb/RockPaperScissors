package com.kodilla.rps;

public final class RpsRunner {

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
                } catch (Exception e) {
                    System.out.println("Invalid entry");
                    continue;
                }

                while (true) {

                    try {
                        player.setPlayerMove();
                    } catch (Exception e) {
                        System.out.println("Invalid entry");
                        continue;
                    }

                    gamePlay.setPlayerMoveName();

                    System.out.println(player.getPlayerName() + " selected " + gamePlay.getPlayerMoveName());

                    computer.setComputerMove();

                    gamePlay.setComputerMoveName();

                    System.out.println("Computer selected " + gamePlay.getComputerMoveName());

                    gamePlay.roundResult(Player.getPlayerMove(), Computer.getComputerMove());

                    gamePlay.showScore(player.getPlayerName());

                    if (gamePlay.getNumberOfRounds() == gamePlay.getNumberOfCompletedRounds()) {
                        gamePlay.winOrLoose(player.getPlayerName());
                        break;
                    }
                }
                gamePlay.breakOrExit();

                if (gamePlay.isBreakOrExit() == true) {
                    gamePlay.resetScore();
                    break;
                }
            }
        }
    }
}