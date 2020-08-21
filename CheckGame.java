package tictactoe;

public class CheckGame {
    Field field;
    boolean winsX = false;
    boolean winsO = false;
    boolean gameNotFinish = true;

    public CheckGame(Field field) {
        this.field = field;
    }

    public boolean gameWin(String letter) {
        for (int i = 0; i < 3; i++) {
            if (field.matrix[i][0].equals(letter) && field.matrix[i][1].equals(letter) && field.matrix[i][2].equals(letter))
                return true;
            if (field.matrix[0][i].equals(letter) && field.matrix[1][i].equals(letter) && field.matrix[2][i].equals(letter))
                return true;
        }
        if (field.matrix[0][0].equals(letter) && field.matrix[1][1].equals(letter) && field.matrix[2][2].equals(letter))
            return true;
        return field.matrix[0][2].equals(letter) && field.matrix[1][1].equals(letter) && field.matrix[2][0].equals(letter);
    }

    public void notFinish() {
        if (!winsX && !winsO) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field.matrix[i][j].equals(" ")) {
                        gameNotFinish = true;
                        return;
                    } else gameNotFinish = false;
                }
            }
        } else {
            gameNotFinish = false;
        }
    }

    public void stateGame() {
        winsX = gameWin("X");
        winsO = gameWin("O");
        notFinish();
    }

    public boolean gameDraw() {
        stateGame();
        return !winsO && !winsX && !gameNotFinish;
    }

    public void printResult() {
        if (winsX)
            System.out.println("X wins");
        else if (winsO)
            System.out.println("O wins");
        else
            System.out.println("Draw");
    }
}
