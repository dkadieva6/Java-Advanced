package Advanced.MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCol = Integer.parseInt(scanner.nextLine());
        int[][] matrix = getMatrix(scanner, rowCol, rowCol);

        int firstDiagonal = 0;
        int secondDiagonal = 0;

        for (int i = 0; i < rowCol; i++) {
            firstDiagonal += matrix[i][i];
            secondDiagonal += matrix[rowCol - 1 - i][i];
        }

        System.out.println(Math.abs(firstDiagonal - secondDiagonal));
    }

    private static int[][] getMatrix(Scanner scanner, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
