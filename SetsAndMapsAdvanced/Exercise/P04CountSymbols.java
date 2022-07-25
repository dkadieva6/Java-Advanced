package Advanced.SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> symbols = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char charToAdd = input.charAt(i);
            symbols.putIfAbsent(charToAdd, 0);
            symbols.put(charToAdd, symbols.get(charToAdd) + 1);
        }

        symbols.forEach((k, v) -> System.out.printf("%s: %d time/s%n", k, v));
    }
}
