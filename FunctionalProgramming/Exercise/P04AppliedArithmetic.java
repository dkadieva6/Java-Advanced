package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class P04AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer[]> maxElement = null;
        UnaryOperator<Integer> add = i -> i + 1;
        UnaryOperator<Integer> multiply = i -> i * 2;
        UnaryOperator<Integer> subtract = i -> i - 1;
        Consumer<Integer[]> printer = intArray -> System.out.println(Arrays.toString(intArray).replaceAll("[]\\[,]", ""));

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        String command;

        while (!"end".equals(command = scanner.nextLine())) {
            switch (command) {
                case "add":
                    maxElement = intArray -> Arrays.stream(intArray).map(add).toArray(Integer[]::new);
                    break;

                case "multiply":
                    maxElement = intArray -> Arrays.stream(intArray).map(multiply).toArray(Integer[]::new);
                    break;

                case "subtract":
                    maxElement = intArray -> Arrays.stream(intArray).map(subtract).toArray(Integer[]::new);
                    break;

                case "print":
                    printer.accept(numbers);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }

            if (!"print".equals(command)) numbers = Objects.requireNonNull(maxElement).apply(numbers);
        }
    }
}
