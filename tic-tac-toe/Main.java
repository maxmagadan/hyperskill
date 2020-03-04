package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static char[][] matrix = new char[3][3];
    static int i;
    static int j;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean isX = true;
        int z = 0;
        int count = 0;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                matrix[i][j] = ' ';
            }
            z += j;
        }


        printField();

        for (;;) {

            System.out.print("Enter the coordinates: ");

            int x = 0;
            int y = 0;

            try {
                x = sc.nextInt();
                y = sc.nextInt();
            }catch (InputMismatchException e) {
                sc.next();
                System.out.println("You should enter numbers!");
                continue;
            }


            if ((x < 1 || x > 3) || (y < 1 || y > 3)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (matrix[3 - y][x - 1] == 'X' || matrix[3 - y][x - 1] == 'O'){
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            if ((matrix[3 - y][x - 1] == ' ' || matrix[3 - y][x - 1] == '_') && isX) {
                matrix[3 - y][x - 1] = 'X';
                count++;
                isX = false;
            }

            if ((matrix[3 - y][x - 1] == ' ' || matrix[3 - y][x - 1] == '_') && !isX) {
                matrix[3 - y][x - 1] = 'O';
                count++;
                isX = true;
            }


            printField();

            int line1 = matrix[0][0] + matrix[0][1] + matrix[0][2];
            int line2 = matrix[1][0] + matrix[1][1] + matrix[1][2];
            int line3 = matrix[2][0] + matrix[2][1] + matrix[2][2];

            int row1 = matrix[0][0] + matrix[1][0] + matrix[2][0];
            int row2 = matrix[0][1] + matrix[1][1] + matrix[2][1];
            int row3 = matrix[0][2] + matrix[1][2] + matrix[2][2];

            int axis1 = matrix[0][0] + matrix[1][1] + matrix[2][2];
            int axis2 = matrix[2][0] + matrix[1][1] + matrix[0][2];

            if (line1 == 264 || line2 == 264 || line3 == 264 || row1 == 264 || row2 == 264 || row3 == 264 || axis1 == 264 || axis2 == 264) {
                System.out.println("X wins");
                break;
            }

            if (line1 == 237 || line2 == 237 || line3 == 237 || row1 == 237 || row2 == 237 || row3 == 237 || axis1 == 237 || axis2 == 237) {
                System.out.println("O wins");
                break;
            }

            if (count == 9) {
                System.out.println("Draw");
                break;
            }

        }

    }

    private static void printField() {

        System.out.println("---------");

        for (i = 0; i < 3; i++) {
            System.out.print("| ");
            for (j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}

