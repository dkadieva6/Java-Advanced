package Advanced.SetsAndMapsAdvanced.Lab;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLine = Integer.parseInt(scanner.nextLine());
        Map<String, Double[]> students = new TreeMap<>();
        for (int i = 0; i < inputLine; i++) {
            String name = scanner.nextLine();
            String[] inputGrade = scanner.nextLine().split("\\s+");
            Double[] grade = new Double[inputGrade.length];

            for (int j = 0; j < grade.length; j++) {
                grade[j] = Double.parseDouble(inputGrade[j]);
            }

            students.put(name, grade);
        }

        students.forEach((key, value) -> {
            double sum = 0;
            for (Double aDouble : value) {
                sum += aDouble;
            }

            System.out.printf("%s is graduated with %s%n", key, sum / value.length);

        });
    }
}
