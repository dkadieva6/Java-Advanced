package Exam7_14_April_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //queue
        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Integer[] tulipsInput = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Collections.addAll(tulips, tulipsInput);

        //stack
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        Integer[] daffodilsInput = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.stream(daffodilsInput).forEach(daffodils::push);

        int countBouquets = 5;
        int left = 0;

        while (!(daffodils.isEmpty() || tulips.isEmpty() || countBouquets > 5)) {
            int singleTulips = tulips.pop();
            int singleDaffodils = daffodils.poll();

            while (true) {
                if (singleTulips + singleDaffodils < 15) {
                    left += singleTulips + singleDaffodils;
                    break;
                } else if (singleTulips + singleDaffodils == 15) {
                    countBouquets--;
                    break;
                } else {
                    singleTulips -= 2;
                }
            }
        }

        countBouquets -= left / 15;

        if (countBouquets <= 0) {
            System.out.println("You made it! You go to the competition with 5 bouquets!");
        } else {
            System.out.println("You failed... You need more " + countBouquets + " bouquets.");
        }
    }
}

/*
10, 15, 2, 7, 9, 13
2, 10, 8, 12, 0, 5

10, 5, 3, 7, 8
5, 10, 8, 7, 6
 */