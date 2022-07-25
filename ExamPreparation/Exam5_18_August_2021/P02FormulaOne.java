package Exam5_18_August_2021;

import java.util.Arrays;
import java.util.Scanner;

public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowMatrix = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rowMatrix][rowMatrix];
        int[] curPlayerRow = new int[2];
        int[] oldPosition = new int[2];

        for (int i = 0; i < rowMatrix; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < rowMatrix; j++) {
                matrix[i][j] = input.charAt(j);
                if (input.charAt(j) == 'P') {
                    curPlayerRow[0] = i;
                    curPlayerRow[1] = j;
                }
            }
        }

        String command;
        boolean finished = false;
        while (countCommands-- > 0) {
            command = scanner.nextLine();
            oldPosition[0] = curPlayerRow[0];
            oldPosition[1] = curPlayerRow[1];
            matrix[curPlayerRow[0]][curPlayerRow[1]] = '.';
            move(command, curPlayerRow, rowMatrix);

            if (matrix[curPlayerRow[0]][curPlayerRow[1]] == 'B') {
                move(command, curPlayerRow, rowMatrix);
            }

            if (matrix[curPlayerRow[0]][curPlayerRow[1]] == 'T') {
                curPlayerRow[0] = oldPosition[0];
                curPlayerRow[1] = oldPosition[1];
            }

            if (matrix[curPlayerRow[0]][curPlayerRow[1]] == 'F') {
                matrix[curPlayerRow[0]][curPlayerRow[1]] = 'P';
                finished = true;
                break;
            }
            matrix[curPlayerRow[0]][curPlayerRow[1]] = 'P';
        }

        if (finished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        Arrays.stream(matrix).map(String::valueOf).forEach(System.out::println);
    }

    public static boolean PlayerInTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }

    public static void move(String command, int[] curPlayerRow, int rowMatrix) {
        switch (command) {
            case "up":
                if (PlayerInTheMatrix(curPlayerRow[0] - 1, curPlayerRow[1], rowMatrix)) {
                    curPlayerRow[0]--;
                } else {
                    curPlayerRow[0] = rowMatrix - 1;
                }
                break;

            case "down":
                if (PlayerInTheMatrix(curPlayerRow[0] + 1, curPlayerRow[1], rowMatrix)) {
                    curPlayerRow[0]++;
                } else {
                    curPlayerRow[0] = 0;
                }
                break;

            case "left":
                if (PlayerInTheMatrix(curPlayerRow[0], curPlayerRow[1] - 1, rowMatrix)) {
                    curPlayerRow[1]--;
                } else {
                    curPlayerRow[1] = rowMatrix - 1;
                }
                break;

            case "right":
                if (PlayerInTheMatrix(curPlayerRow[0], curPlayerRow[1] + 1, rowMatrix)) {
                    curPlayerRow[1]++;
                } else {
                    curPlayerRow[1] = 0;
                }
                break;
        }
    }
}
