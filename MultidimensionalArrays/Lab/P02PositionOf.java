package Advanced.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int matrixRows = dimensions[0];
        int matrixCols = dimensions[1];

        int[][] matrix = new int[matrixRows][];

        for (int i = 0; i < matrixRows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = arr;
        }

        int n = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int row = 0; row < matrixRows; row++) {
            for (int col = 0; col < matrixCols; col++) {
                if (matrix[row][col] == n) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}
