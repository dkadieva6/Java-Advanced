package Advanced.MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    private static char[][] getMatrix (Scanner scanner, int row, int col) {
        char[][] matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }

        return matrix;
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = getMatrix(scanner, row, col);
        char[][] secondMatrix = getMatrix(scanner, row, col);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char output = firstMatrix[i][j] == secondMatrix[i][j] ? firstMatrix[i][j] : '*';
                System.out.print(output + " ");
            }

            System.out.println();
        }

    }
}
