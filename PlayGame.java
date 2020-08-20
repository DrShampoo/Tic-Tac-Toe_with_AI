package tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayGame {
    Field field;
    CheckGame checkGame;
    ComputerPlayer player;
    List<String> commands = Arrays.asList("user", "easy", "medium");


    public PlayGame(Field field, CheckGame checkGame, ComputerPlayer player) {
        this.field = field;
        this.checkGame = checkGame;
        this.player = player;
    }

    public void playUserVsUser (Scanner scanner) {
        field.drawMatrix();
        while (checkGame.gameNotFinish) {
            field.playUser(scanner, "X");
            checkGame.stateGame();
            if (checkGame.gameNotFinish) field.playUser(scanner, "O");
            checkGame.stateGame();
        }
        checkGame.printResult();
    }

    public void playUserVsComp (String player1, String player2, Scanner scanner) {
        field.drawMatrix();
        String letterUs = "O";
        String letterComp = "X";
        if (player1.equals("user")) {
            letterUs = "X";
            letterComp = "O";
        }
        while (checkGame.gameNotFinish) {
            if (player1.equals("user")) {
                field.playUser(scanner, letterUs);
                checkGame.stateGame();
                if (checkGame.gameNotFinish) player.play(letterComp, letterUs, player2);
            } else {
                player.play(letterComp, letterUs, player1);
                checkGame.stateGame();
                if (checkGame.gameNotFinish) field.playUser(scanner, letterUs);
            }
            checkGame.stateGame();
        }
        checkGame.printResult();
    }

    public void playCompVsComp (String player1, String player2) {
        field.drawMatrix();
        while (checkGame.gameNotFinish) {
            player.play("X","O", player1);
            checkGame.stateGame();
            if (checkGame.gameNotFinish) player.play("O","X", player2);
            checkGame.stateGame();
        }
        checkGame.printResult();
    }

    public void chooseDifficulty (String difficulty) {
        if (difficulty.equals("easy")) {

        } else if (difficulty.equals("medium")) {
            
        } else {

        }
    }

}
