package Advanced.StackAndQueue.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> number = new ArrayDeque<>();
        int elementToPush = scanner.nextInt();
        int elementToPop = scanner.nextInt();
        int elementToCheck = scanner.nextInt();
        for (int i = 0; i < elementToPush; i++) {
            number.offer(scanner.nextInt());
        }
        for (int i = 0; i < elementToPop; i++) {
            number.poll();
        }
        if (number.size() == 0) System.out.println(0);
        else if (number.contains(elementToCheck)) System.out.println("true");
        else System.out.println(number.stream().min(Integer::compare).get());
    }
}
