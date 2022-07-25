package Advanced.SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] elements = scanner.nextLine().split("\\s+");
        int elementForFirst = Integer.parseInt(elements[0]);
        int elementForSecond = Integer.parseInt(elements[1]);

        Set<Integer> firstNumbers = new LinkedHashSet<>();
        Set<Integer> secondNumbers = new LinkedHashSet<>();
        for (int i = 0; i < elementForFirst; i++) {
            int numberToAdd = Integer.parseInt(scanner.nextLine());
            firstNumbers.add(numberToAdd);
        }

        for (int i = 0; i < elementForSecond; i++) {
            int numberToAdd = Integer.parseInt(scanner.nextLine());
            secondNumbers.add(numberToAdd);
        }

        firstNumbers.retainAll(secondNumbers);
        firstNumbers.forEach(number -> System.out.print(number + " "));
    }
}
