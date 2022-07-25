package Exam6_26_June_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //stack
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Integer[] tasksInput = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.stream(tasksInput).forEach(tasks::push);

        //queue
        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Integer[] threadsInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Collections.addAll(threads, threadsInput);

        int taskToKill = Integer.parseInt(scanner.nextLine());
        while (true) {
            if (tasks.peek() == taskToKill) {
                System.out.println("Thread with value " + threads.peek() + " killed task " + taskToKill);
                break;
            } else if (threads.peek() >= tasks.peek()) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }
        }

        System.out.println(threads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}

/*
20, 23, 54, 34, 90
150 64 20 34
54

33, 12, 15, 40, 45, 60
30 20 53 67 84 90
40
 */