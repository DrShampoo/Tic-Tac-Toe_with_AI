package tictactoe;

import java.util.Random;

public class ComputerPlayer {
    Field field;
    Random random = new Random();

    public ComputerPlayer(Field field) {
        this.field = field;
    }

    public void play(String letterComp, String oppLetter) {
        while (true) {
            int i = random.nextInt(3);
            int j = random.nextInt(3);
            if (field.matrix[i][j].equals(" ")) {
                field.matrix[i][j] = letterComp;
                break;
            }
        }
    }
}
