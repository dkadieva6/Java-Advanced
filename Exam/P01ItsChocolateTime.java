package Advanced.Exam;

import java.util.*;

public class P01ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //queue
        ArrayDeque<Double> milkQuantity = new ArrayDeque<>();
        Double[] milkInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).toArray(Double[]::new);
        Arrays.stream(milkInput).forEach(milkQuantity::offer);

        //stack
        ArrayDeque<Double> cacaoQuantity = new ArrayDeque<>();
        Double[] cacaoInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).toArray(Double[]::new);
        Arrays.stream(cacaoInput).forEach(cacaoQuantity::push);

        Map<Double, String> chocolates = new HashMap<>();
        chocolates.put(30.0, "Milk Chocolate");
        chocolates.put(50.0, "Dark Chocolate");
        chocolates.put(100.0, "Baking Chocolate");
        Map<String, Integer> madeChocolates = new TreeMap<>();

        while (!(milkQuantity.isEmpty() || cacaoQuantity.isEmpty())) {
            double singleMilk = milkQuantity.poll();
            double singleCacao = cacaoQuantity.pop();
            double cacaoPercentage = singleCacao / (singleMilk + singleCacao);
            cacaoPercentage *= 100;

            if (chocolates.containsKey(cacaoPercentage)) {
                String chocolateType = chocolates.get(cacaoPercentage);
                madeChocolates.putIfAbsent(chocolateType, 0);
                madeChocolates.put(chocolateType, madeChocolates.get(chocolateType) + 1);
            } else {
                milkQuantity.offer(singleMilk + 10);
            }
        }

        if (madeChocolates.size() >= 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        madeChocolates.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));
    }
}
