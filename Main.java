package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Field field = new Field();
        CheckGame checkGame = new CheckGame(field);
        ComputerPlayer player = new ComputerPlayer(field);
        PlayGame play = new PlayGame(field, checkGame, player);

        String line;
        String[] commands;

        while (true) {
            System.out.println("Input command:");
            line = scanner.nextLine();
            commands = line.split(" ");
            if (commands.length != 3) {
                System.out.println("Bad parameters!");
            } else if (!commands[0].equals("start")) {
                System.out.println("Bad parameters!");
            } else if (!play.commands.contains(commands[1]) || !play.commands.contains(commands[2])) {
                System.out.println("Bad parameters!");
            } else {
                break;
            }
        }

        if (commands[1].equals("user") ^ commands[2].equals("user")) {
            play.playUserVsComp(commands[1], commands[2], scanner);
        } else if (commands[1].equals("user")) {
            play.playUserVsUser(scanner);
        } else {
            play.playCompVsComp(commands[1],commands[2]);
        }
    }
}
