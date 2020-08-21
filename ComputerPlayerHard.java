package tictactoe;

public class ComputerPlayerHard extends ComputerPlayer {
    Field imitationField = new Field();
    CheckGame checkImitation = new CheckGame(imitationField);
    final boolean AI_TURN = true;
    final boolean USER_TURN = false;

    public enum Scores {
        USER(-100),
        COMPUTER(100),
        DRAW(0),
        ;
        int count;

        Scores(int count) {
            this.count = count;
        }
    }


    public ComputerPlayerHard(Field field) {
        super(field);
    }

    @Override
    public void play(String letterComp, String oppLetter) {
        int bestScore = Integer.MIN_VALUE;
        int score;
        arrayCopy();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (imitationField.matrix[i][j].equals(" ")) {
                    imitationField.matrix[i][j] = letterComp;
                    score = miniMax(0, USER_TURN, letterComp, oppLetter);
                    imitationField.matrix[i][j] = " ";
                    if (score > bestScore) {
                        bestScore = score;
                        field.matrix[i][j] = letterComp;
                        System.out.println("Making move level \"hard\"");
                        field.printMatrix();
                    }
                }
            }
        }
    }

    private int miniMax(int count, boolean aiTurn, String letterComp, String oppLetter) {
        if (checkImitation.gameWin(letterComp)) {
            return Scores.COMPUTER.count;
        } else if (checkImitation.gameWin(oppLetter)) {
            return Scores.USER.count;
        } else if (checkImitation.gameDraw()) {
            return Scores.DRAW.count;
        }
        int bestScore;
        if (aiTurn) {
            bestScore = Integer.MIN_VALUE;
            int score;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++){
                    if (imitationField.matrix[i][j].equals(" ")) {
                        imitationField.matrix[i][j] = letterComp;
                        score = miniMax(count + 1, USER_TURN, letterComp, oppLetter);
                        imitationField.matrix[i][j] = " ";
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
        } else {
            bestScore = Integer.MAX_VALUE;
            int score;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (imitationField.matrix[i][j].equals(" ")) {
                        imitationField.matrix[i][j] = oppLetter;
                        score = miniMax(count + 1, AI_TURN, letterComp, oppLetter);
                        imitationField.matrix[i][j] = " ";
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
        }
        return bestScore;
    }

    public void arrayCopy() {
        for (int i = 0; i < 3; i++) {
            System.arraycopy(field.matrix[i], 0, imitationField.matrix[i], 0, 3);
        }
    }
}
