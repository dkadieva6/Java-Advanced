package Advanced.StackAndQueue.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> number = new ArrayDeque<>();

        int elementToPush = scanner.nextInt();
        int elementToPop = scanner.nextInt();
        int elementToCheck = scanner.nextInt();
        for (int i = 0; i < elementToPush; i++) {
            number.push(scanner.nextInt());
        }

        for (int i = 0; i < elementToPop; i++) {
            number.pop();
        }

        if (number.size() == 0) {
            System.out.println(0);
        } else if (number.contains(elementToCheck)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(number));
        }
    }
}
