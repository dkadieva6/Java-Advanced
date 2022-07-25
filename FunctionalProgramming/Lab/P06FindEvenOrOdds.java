package Advanced.FunctionalProgramming.Lab;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class P06FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] range = scanner.nextLine().split("\\s+");
        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);
        String oddOrEven = scanner.nextLine();

        IntPredicate filterByAge = "odd".equals(oddOrEven) ? i -> i % 2 != 0 : i -> i % 2 == 0;
        IntStream.range(start, end + 1).filter(filterByAge).forEach(i -> System.out.printf("%d ",  i));
    }
}
