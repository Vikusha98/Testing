package ru.netology;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    static void fillMatrix(char[][] game) {
        for (char[] chars : game) {
            Arrays.fill(chars, '_');
        }
    }


    public static void move(char[][] game, char currentPlayer) {
        int row;
        int col;

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите строку: ");
            row = scanner.nextInt();
            System.out.print("Введите столбец: ");
            col = scanner.nextInt();

            if (row < 0 || col < 0 || row > 2 || col > 2) {
                System.out.println("Некорректные данные!");
            } else {
                break;

            }

        }
        game[row][col] = currentPlayer;
    }

    static void printMatrix(char[][] game) {
        for (char[] chars : game) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static boolean checkWin(char[][] game, char currentPlayer) {

        if (game[0][0] == game[1][1] && game[1][1] == game[2][2] && game[0][0] == currentPlayer) {

            return true;
        } else if (game[2][0] == game[1][1] && game[1][1] == game[0][2] && game[2][0] == currentPlayer) {
            return true;
        }


        for (int i = 0; i < game.length; i++) {
            if (game[i][0] == game[i][1] && game[i][1] == game[i][2] && game[i][0] == currentPlayer) {
                return true;


            }

            if (game[0][i] == game[1][i] && game[1][i] == game[2][i] && game[0][i] == currentPlayer) {
                return true;


            }
        }

        return false;
    }



    public static boolean checkDraw(char[][] game) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; j++) {
                if (game[i][j] == '_') {
                    return false;
                }
            }


        }
        return true;
    }

    public static void main(String[] args) {
        char[][] game = new char[3][3];
        fillMatrix(game);
        printMatrix(game);

        char currentPlayer = 'X';
        while (true) {
            System.out.println("Сейчас ходит " + currentPlayer);

            move(game, currentPlayer);
            printMatrix(game);

            if (checkWin(game, currentPlayer)) {
                System.out.println("Победил " + currentPlayer);
                break;
            } else if (checkDraw(game)) {
                System.out.println("Ничья");
                break;
            } else {
                currentPlayer = currentPlayer == 'X' ? '0' : 'X';
            }
        }
    }
}

