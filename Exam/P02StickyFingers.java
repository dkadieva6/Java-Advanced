package Advanced.Exam;

import java.util.Scanner;

public class P02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsMatrix = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[rowsMatrix][rowsMatrix];
        String[] commands = scanner.nextLine().split(",");
        int[] dillingerPosition = new int[2];

        for (int i = 0; i < rowsMatrix; i++) {
            String input = scanner.nextLine();
            matrix[i] = input.split("\\s+");
            for (int j = 0; j < rowsMatrix; j++) {
                if (matrix[i][j].equals("D")) {
                    matrix[i][j] = "+";
                    dillingerPosition[0] = i;
                    dillingerPosition[1] = j;
                }
            }
        }

        int money = 0;
        boolean caught = false;
        for (String command : commands) {
            matrix[dillingerPosition[0]][dillingerPosition[1]] = "+";
            move(command, dillingerPosition, rowsMatrix);

            if (matrix[dillingerPosition[0]][dillingerPosition[1]].equals("$")) {
                matrix[dillingerPosition[0]][dillingerPosition[1]] = "+";
                money += dillingerPosition[0] * dillingerPosition[1];
                System.out.printf("You successfully stole %d$.%n", dillingerPosition[0] * dillingerPosition[1]);
            }

            if (matrix[dillingerPosition[0]][dillingerPosition[1]].equals("P")) {
                caught = true;
                matrix[dillingerPosition[0]][dillingerPosition[1]] = "#";
                break;
            }

            matrix[dillingerPosition[0]][dillingerPosition[1]] = "D";
        }

        if (!caught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", money);
        } else {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", money);
        }

        for (int i = 0; i < rowsMatrix; i++) {
            for (int j = 0; j <rowsMatrix; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean dillingerInMatrix(int row, int col, int rowsMatrix) {
        return row >= 0 && row < rowsMatrix && col >= 0 && col < rowsMatrix;
    }

    private static void move(String command, int[] dillingerPosition, int rowsMatrix) {
        switch (command) {
            case "up":
                if (dillingerInMatrix(dillingerPosition[0] - 1, dillingerPosition[1], rowsMatrix)) {
                    dillingerPosition[0]--;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
                break;

            case "down":
                if (dillingerInMatrix(dillingerPosition[0] + 1, dillingerPosition[1], rowsMatrix)) {
                    dillingerPosition[0]++;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
                break;

            case "left":
                if (dillingerInMatrix(dillingerPosition[0], dillingerPosition[1] - 1, rowsMatrix)) {
                    dillingerPosition[1]--;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
                break;

            case "right":
                if (dillingerInMatrix(dillingerPosition[0], dillingerPosition[1] + 1, rowsMatrix)) {
                    dillingerPosition[1]++;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
                break;
        }
    }
}

