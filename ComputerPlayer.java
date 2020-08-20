package tictactoe;

import java.util.Random;

public class ComputerPlayer {
    Field field;
    Random random = new Random();

    public ComputerPlayer(Field field) {
        this.field = field;
    }

    public void play(String letter, String oppLetter, String difficulty) {
        if (difficulty.equals("easy")) {
            playEasy(letter, "easy");
        } else {
            playMedium(letter, oppLetter);
        }
    }

    public void playMedium(String letterComp, String oppLetter) {
        if (checkMove(letterComp, letterComp)) {
            System.out.println("Making move \"medium\"");
            field.printMatrix();
        } else if (checkMove(oppLetter, letterComp)) {
            System.out.println("Making move \"medium\"");
            field.printMatrix();
        } else {
            playEasy(letterComp, "medium");
        }
    }

    public void playEasy(String letter, String difficulty) {
        int i = random.nextInt(3);
        int j = random.nextInt(3);
        if (!field.matrix[i][j].equals(" ")) {
            playEasy(letter, letter);
        } else {
            field.matrix[i][j] = letter;
            System.out.printf("Making move level \"%s\"%n", difficulty);
            field.printMatrix();
        }
    }

    public boolean checkRows(String letterOpp, String letterComp) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field.matrix[i][j].equals(" ") && field.matrix[i][j - 1 < 0 ? 2 : j - 1].equals(letterOpp) &&
                        field.matrix[i][j + 1 > 2 ? 0 : j + 1].equals(letterOpp)) {
                    field.matrix[i][j] = letterComp;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkColumns(String letterOpp, String letterComp) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field.matrix[j][i].equals(" ") && field.matrix[j - 1 < 0 ? 2 : j - 1][i].equals(letterOpp) &&
                        field.matrix[j + 1 > 2 ? 0 : j + 1][i].equals(letterOpp)) {
                    field.matrix[j][i] = letterComp;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonals(String letterOpp, String letterComp) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field.matrix[i][i].equals(" ") && field.matrix[i - 1 < 0 ? 2 : i - 1][i - 1 < 0 ? 2 : i - 1].equals(letterOpp) &&
                        field.matrix[i + 1 > 2 ? 0 : i + 1][i + 1 > 2 ? 0 : i + 1].equals(letterOpp)) {
                    field.matrix[i][i] = letterComp;
                    return true;
                } else if (field.matrix[i][2 - j].equals(" ") && field.matrix[i + 1 > 2 ? 0 : i + 1][1 - j < 0 ? 2 : 1 - j].equals(letterOpp) &&
                    field.matrix[i - 1 < 0 ? 2 : i - 1][3 - j > 2 ? 0 : 3 - j].equals(letterOpp)) {
                    field.matrix[i][2 - j] = letterComp;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkMove(String letterOpp, String letterComp) {
        if (checkRows(letterOpp, letterComp)) return true;
        else if (checkColumns(letterOpp, letterComp)) return true;
        return checkDiagonals(letterOpp, letterComp);
    }
}
