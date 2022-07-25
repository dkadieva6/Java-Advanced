package Advanced.StackAndQueue.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P06RecursiveFibonacci {
    private final Map<Integer, Long> memorizeTable = new HashMap<>(); // O(1)

    public long fibonacciMemorize(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        if (this.memorizeTable.containsKey(n)) {
            return this.memorizeTable.get(n);
        }

        long result = fibonacciMemorize(n - 1) + fibonacciMemorize(n - 2);
        this.memorizeTable.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        P06RecursiveFibonacci fibonacciAlgorithm = new P06RecursiveFibonacci();
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(fibonacciAlgorithm.fibonacciMemorize(n));
    }
}
