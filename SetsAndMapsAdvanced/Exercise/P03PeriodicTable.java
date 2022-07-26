package Advanced.SetsAndMapsAdvanced.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLine = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalElements = new TreeSet<>();
        for (int i = 0; i < inputLine; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(elements));
        }

        System.out.println(String.join(" ", chemicalElements));
    }
}
