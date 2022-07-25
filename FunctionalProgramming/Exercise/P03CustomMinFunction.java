package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<Integer[], Integer> maxElement = intArray -> Arrays.stream(intArray).sorted().findFirst().orElse(0);
        System.out.println(maxElement.apply(Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new)));
    }
}
