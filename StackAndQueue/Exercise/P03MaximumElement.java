package Advanced.StackAndQueue.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> number = new ArrayDeque<>();
        int command = scanner.nextInt();
        for (int i = 0; i < command; i++) {
            switch (scanner.nextInt()){
                case 1:
                    number.push(scanner.nextInt());
                    break;

                case 2:
                    number.pop();
                    break;

                case 3:
                    System.out.println(Collections.max(number));
                    //System.out.println(number.stream().max(Integer::compare).get());
                    break;

                default:
                    System.out.println("invalid command");
            }
        }
    }
}
