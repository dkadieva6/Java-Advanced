package Exam5_18_August_2021;

import java.util.*;
import java.util.stream.Collectors;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //queue
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        //stack
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Integer[] liquidsInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] ingredientsInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);

        Collections.addAll(liquids, liquidsInput);
        Arrays.stream(ingredientsInput).forEach(ingredients::push);

        Map<Integer, String> neededValue = new HashMap<>();
        neededValue.put(25, "Biscuit");
        neededValue.put(50, "Cake");
        neededValue.put(75, "Pastry");
        neededValue.put(100, "Pie");
        Map<String, Integer> makeFood = new TreeMap<>();

        while(!(liquids.isEmpty() || ingredients.isEmpty())) {
            int singleLiquid = liquids.poll();
            int singleIngredient = ingredients.pop();
            int totalIngredients = singleLiquid + singleIngredient;

            if (neededValue.containsKey(totalIngredients)) {
                String food = neededValue.get(totalIngredients);
                makeFood.putIfAbsent(food, 0);
                makeFood.put(food, makeFood.get(food) + 1);
            } else {
                ingredients.push(singleIngredient + 3);
            }
        }

        String result;
        if (makeFood.size() == 4) {
            result = "Great! You succeeded in cooking all the food!";
        } else {
            result = "What a pity! You didn't have enough materials to cook everything.";
        }
        System.out.println(result);

        if (liquids.isEmpty()) {
            result = "Liquids left: none";
        } else {
            result = String.format("Liquids left: %s", liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);

        if (ingredients.isEmpty()) {
            result = "Ingredients left: none";
        } else {
            result = String.format("Ingredients left: %s", ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);

        System.out.println("Biscuit: " + (makeFood.getOrDefault("Biscuit", 0)));
        System.out.println("Cake: " + (makeFood.getOrDefault("Cake", 0)));
        System.out.println("Pie: " + (makeFood.getOrDefault("Pie", 0)));
        System.out.println("Pastry: " + (makeFood.getOrDefault("Pastry", 0)));
    }
}

/*
1 25 50 50
50 25 25 24

10 20 30 40 50
50 40 30 30 15
 */