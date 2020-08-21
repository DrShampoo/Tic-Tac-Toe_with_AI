package tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayGame {
    Field field;
    CheckGame checkGame;
    List<String> commands = Arrays.asList("user", "easy", "medium", "hard");


    public PlayGame(Field field, CheckGame checkGame) {
        this.field = field;
        this.checkGame = checkGame;
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
        ComputerPlayer computerPlayer;

        if (player1.equals("user")) {
            computerPlayer = chooseDifficultyComputer(player2);
            while (checkGame.gameNotFinish) {
                field.playUser(scanner, "X");
                checkGame.stateGame();
                if (checkGame.gameNotFinish) computerPlayer.play("O", "X");
                checkGame.stateGame();
            }
        } else {
            computerPlayer = chooseDifficultyComputer(player1);
            while (checkGame.gameNotFinish) {
                computerPlayer.play("X", "O");
                checkGame.stateGame();
                if (checkGame.gameNotFinish) field.playUser(scanner, "O");
                checkGame.stateGame();
            }
        }
        checkGame.printResult();
    }

    public void playCompVsComp (String player1, String player2) {
        field.drawMatrix();
        ComputerPlayer computerPlayer1 = chooseDifficultyComputer(player1);
        ComputerPlayer computerPlayer2 = chooseDifficultyComputer(player2);

        while (checkGame.gameNotFinish) {
            computerPlayer1.play("X","O");
            checkGame.stateGame();
            if (checkGame.gameNotFinish) computerPlayer2.play("O","X");
            checkGame.stateGame();
        }
        checkGame.printResult();
    }

    public ComputerPlayer chooseDifficultyComputer(String difficulty) {
        if (difficulty.equals("easy")) {
            return new ComputerPlayerEasy(field);
        } else if (difficulty.equals("medium")) {
            return new ComputerPlayerMedium(field);
        } else {
            return new ComputerPlayerHard(field);
        }
    }

}
