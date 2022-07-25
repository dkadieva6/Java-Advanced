package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class P04AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> taxWithVat = i -> i * 1.2;
        Consumer<Double> printer = i -> System.out.printf("%.2f%n", i);
        Function<String, Double> parser = Double::parseDouble;

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(parser)
                .map(taxWithVat)
                .forEach(printer);
    }
}
