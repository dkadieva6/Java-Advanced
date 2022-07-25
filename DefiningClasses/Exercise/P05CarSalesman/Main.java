package Advanced.DefiningClasses.Exercise.P05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engineInCatalog = new HashMap<>();
        List<Car> carsInCatalog = new ArrayList<>();

        while (line-- > 0) {
            String[] token = scanner.nextLine().split("\\s+");
            String model = token[0];
            int power = Integer.parseInt(token[1]);
            Engine singleEngine = null;

            if (token.length == 2) {
                singleEngine = new Engine(model, power);
            }

            if (token.length == 3) {
                if (token[2].chars().allMatch(Character::isDigit)) {
                    singleEngine = new Engine(model, power, Integer.parseInt(token[2]));
                } else {
                    singleEngine = new Engine(model, power, token[2]);
                }
            }

            if (token.length == 4) {
                singleEngine = new Engine(model, power, Integer.parseInt(token[2]), token[3]);
            }

            engineInCatalog.put(model, singleEngine);
        }

        line = Integer.parseInt(scanner.nextLine());
        while (line-- > 0) {
            String[] token = scanner.nextLine().split("\\s+");
            String model = token[0];
            String engine = token[1];
            Car singleCar = null;
            Engine tempEngine = engineInCatalog.get(engine);

            if (token.length == 2) {
                singleCar = new Car(model, tempEngine);
            }

            if (token.length == 3) {
                if (token[2].chars().allMatch(Character::isDigit)) {
                    singleCar = new Car(model, tempEngine, Integer.parseInt(token[2]));
                } else {
                    singleCar = new Car(model, tempEngine, token[2]);
                }
            }

            if (token.length == 4) {
                singleCar = new Car(model, tempEngine, Integer.parseInt(token[2]), token[3]);
            }

            carsInCatalog.add(singleCar);
        }

        carsInCatalog.forEach(System.out::println);
    }
}

/*
2
V8-101 220 50
V4-33 140 28 B
3
FordFocus V4-33 1300 Silver
FordMustang V8-101
VolkswagenGolf V4-33 Orange

4
DSL-10 280 B
V7-55 200 35
DSL-13 305 55 A+
V7-54 190 30 D
4
FordMondeo DSL-13 Purple
VolkswagenPolo V7-54 1200 Yellow
VolkswagenPassat DSL-10 1375 Blue
FordFusion DSL-13
 */
