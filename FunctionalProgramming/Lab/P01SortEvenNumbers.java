package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).filter(i -> i % 2 != 1).collect(Collectors.toList());
        System.out.println(String.join(", ", numbers.toString().replaceAll("[\\[\\]]", "")));
        Collections.sort(numbers);
        System.out.println(String.join(", ", numbers.toString().replaceAll("[\\[\\]]", "")));
    }
}
