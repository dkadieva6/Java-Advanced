package Advanced.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[sizes[0]][];
            for (int cols = 0; cols < matrix.length; cols++) {
                matrix[cols] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            }
        System.out.println(sizes[0]);
        System.out.println(sizes[1]);

        int sum = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                sum += matrix[rows][cols];
            }
        }

        System.out.println(sum);
    }
}
