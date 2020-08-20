package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Field {
    String[][] matrix = new String[3][3];

    public void drawMatrix() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
               matrix[i][j] = " ";
            }
        }
        printMatrix();
    }

    public void printMatrix() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public void playUser(Scanner scanner, String letter) {
        while (true) {
            System.out.println("Enter the coordinates:");
            try {
                int j = scanner.nextInt();
                int i = scanner.nextInt();
                if ((i < 1 || i > 3) || (j < 1 || j > 3)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (!matrix[Math.abs(i - 3)][j - 1].equals(" "))
                    System.out.println("This cell is occupied! Choose another one!");
                else {
                    matrix[Math.abs(i - 3)][j - 1] = letter;
                    printMatrix();
                    return;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
            }
        }
    }
}
