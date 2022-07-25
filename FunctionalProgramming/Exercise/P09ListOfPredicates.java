package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int end = Integer.parseInt(scanner.nextLine());
        Integer[] divideNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Predicate<Integer> numberToPrint = i -> Arrays.stream(divideNumbers).allMatch(divide -> i % divide == 0);
        System.out.println(IntStream.range(1, end + 1)
                .boxed()
                .filter(numberToPrint)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
