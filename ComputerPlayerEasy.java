package tictactoe;

public class ComputerPlayerEasy extends ComputerPlayer{
    public ComputerPlayerEasy(Field field) {
        super(field);
    }

    @Override
    public void play(String letterComp, String oppLetter) {
        super.play(letterComp, oppLetter);
        System.out.println("Making move \"easy\"");
        field.printMatrix();
    }
}
