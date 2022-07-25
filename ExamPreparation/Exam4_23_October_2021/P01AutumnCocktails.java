package Exam4_23_October_2021;

import java.util.*;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //queue
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        //stack
        ArrayDeque<Integer> freshness = new ArrayDeque<>();

        Integer[] ingredientsInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] freshnessInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Collections.addAll(ingredients, ingredientsInput);
        Arrays.stream(freshnessInput).forEach(freshness::push);

        Map<Integer, String> neededFreshnessLevel = new HashMap<>();
        neededFreshnessLevel.put(150, "Pear Sour");
        neededFreshnessLevel.put(250, "The Harvest");
        neededFreshnessLevel.put(300, "Apple Hinny");
        neededFreshnessLevel.put(400, "High Fashion");

        Map<String, Integer> makeCocktails = new TreeMap<>();
        while (!(ingredients.isEmpty() || freshness.isEmpty())) {
            int singleIngredient = ingredients.poll();
            if (singleIngredient == 0) {
                continue;
            }

            int singleFreshnessLevel = freshness.pop();
            int totalFreshnessLevel = singleIngredient * singleFreshnessLevel;
            if (neededFreshnessLevel.containsKey(totalFreshnessLevel)) {
                String makeCocktail = neededFreshnessLevel.get(totalFreshnessLevel);
                makeCocktails.putIfAbsent(makeCocktail, 0);
                makeCocktails.put(makeCocktail, makeCocktails.get(makeCocktail) + 1);
            } else {
                ingredients.offer(singleIngredient + 5);
            }
        }

        if (makeCocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()) {
            int sum = 0;
            while (!ingredients.isEmpty()) {
                sum += ingredients.poll();
            }
            System.out.println("Ingredients left: " + sum);
        }

        makeCocktails.forEach((key, value) -> System.out.printf(" # %s --> %d%n", key, value));
    }
}

/*
10 10 12 8 10 12
25 15 50 25 25 15

12 20 0 6 19
12 12 25
 */