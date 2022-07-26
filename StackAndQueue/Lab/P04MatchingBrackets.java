package Advanced.StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> indexOfBrackets = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                indexOfBrackets.push(i);
            }

            if (input.charAt(i) == ')') {
                int index = indexOfBrackets.pop();
                System.out.println(input.substring(index, i + 1));
            }
        }
    }
}
