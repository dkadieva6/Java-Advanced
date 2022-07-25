package Advanced.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCol = Integer.parseInt(scanner.nextLine());
        int[][] matrix = getMatrix(scanner, rowCol, rowCol);

        for (int i = 0; i < rowCol; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < rowCol; i++) {
            System.out.print(matrix[rowCol - i - 1][i] + " ");
        }
    }

    private static int[][] getMatrix(Scanner scanner, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
