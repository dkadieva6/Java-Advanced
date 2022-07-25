package Advanced.MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rotationNumber = (Integer.parseInt(scanner.nextLine().replaceAll("[Rotate()]", "")) / 90) % 4;
        List<String> input = new ArrayList<>();
        String line;
        int row = 0;
        int col = 0;

        while (!"END".equals(line = scanner.nextLine())) {
            col = Math.max(col, line.length());
            input.add(line);
            row = input.size();
        }

        String[][] matrix = getMatrix(input, row, col);

        if (rotationNumber % 2 == 1) {
            int temp = col;
            col = row;
            row = temp;
        }

        String[][] finalMatrix = new String[row][col];
        switch (rotationNumber) {
            case 0:
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        finalMatrix[i][j] = matrix[i][j];
                    }
                }
                break;

            case 1:
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        finalMatrix[i][j] = matrix[col - j - 1][i];
                    }
                }
                break;

            case 2:
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        finalMatrix[i][j] = matrix[row - i - 1][col - j - 1];
                    }
                }
                break;

            case 3:
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        finalMatrix[i][j] = matrix[j][row - i - 1];
                    }
                }
                break;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(finalMatrix[i][j]);
            }
            System.out.println();
        }
    }

    private static String[][] getMatrix(List<String> input, int row, int col) {
        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j < input.get(i).length()) {
                    matrix[i][j] = String.valueOf(input.get(i).charAt(j));
                } else {
                    matrix[i][j] = " ";
                }
            }
        }

        return matrix;
    }
}
