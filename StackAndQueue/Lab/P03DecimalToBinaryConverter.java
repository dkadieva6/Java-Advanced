package Advanced.StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (number != 0) {
            stack.push(number % 2);
            number /= 2;
        }

        if (stack.size() == 0) {
            System.out.print(0);
        } else {
            stack.forEach(System.out::print);
        }
    }
}
