package Exam1_13_April_2022;

import java.util.*;
import java.util.stream.Collectors;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> steel = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> carbon = new ArrayDeque<>(); //stack
        Integer[] steels = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] carbons = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);

        Collections.addAll(steel, steels);
        Arrays.stream(carbons).forEach(carbon::push);

        Map<Integer, String> needResourcesForSword = new HashMap<>();
        needResourcesForSword.put(70, "Gladius");
        needResourcesForSword.put(80, "Shamshir");
        needResourcesForSword.put(90, "Katana");
        needResourcesForSword.put(110, "Sabre");
        Map<String, Integer> forgedSwords = new TreeMap<>();

        while (!(steel.isEmpty() || carbon.isEmpty())) {
            int singleSteel = steel.poll();
            int singleCarbon = carbon.pop();
            int haveResources = singleSteel + singleCarbon;

            if (needResourcesForSword.containsKey(haveResources)) {
                String forgedSword = needResourcesForSword.get(singleSteel + singleCarbon);
                forgedSwords.putIfAbsent(forgedSword, 0);
                forgedSwords.put(forgedSword, forgedSwords.get(forgedSword) + 1);
            } else {
                carbon.push(singleCarbon + 5);
            }
        }

        String result;
        if (forgedSwords.isEmpty()) {
            result = "You did not have enough resources to forge a sword.";
        } else {
            result = String.format("You have forged %s swords.", forgedSwords.values().stream().reduce(0, Integer::sum));
        }
        System.out.println(result);

        if (steel.isEmpty()) {
            result = "Steel left: none";
        } else {
            result = String.format("Steel left: %s", steel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);

        if (carbon.isEmpty()) {
            result = "Carbon left: none";
        } else {
            result = String.format("Carbon left: %s", carbon.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);

        forgedSwords.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}


/*
40 50 70 120 10 20
30 20 30 20 30 50

10 5 30
30 20 10
 */