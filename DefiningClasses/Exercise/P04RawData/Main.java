package Advanced.DefiningClasses.Exercise.P04RawData;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    private String model;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = Integer.parseInt(scanner.nextLine());
        Map<String, List<Car>> carInCatalog = new HashMap<>();
        carInCatalog.put("fragile", new ArrayList<>());
        carInCatalog.put("flamable", new ArrayList<>());

        while (line-- > 0) {
            String[] token = scanner.nextLine().split("\\s+");
            String model = token[0];
            int speed = Integer.parseInt(token[1]);
            int power = Integer.parseInt(token[2]);
            int weight = Integer.parseInt(token[3]);
            String type = token[4];
            double tireOnePressure = Double.parseDouble(token[5]);
            int tireOneAge = Integer.parseInt(token[6]);
            double tireTwoPressure = Double.parseDouble(token[7]);
            int tireTwoAge = Integer.parseInt(token[8]);
            double tireThreePressure = Double.parseDouble(token[9]);
            int tireThreeAge = Integer.parseInt(token[10]);
            double tireFourPressure = Double.parseDouble(token[11]);
            int tireFourAge = Integer.parseInt(token[12]);

            Car singleCar = new Car(model, speed, power, weight,type,
                    tireOnePressure, tireOneAge,
                    tireTwoPressure, tireTwoAge,
                    tireThreePressure, tireThreeAge,
                    tireFourPressure, tireFourAge);
            carInCatalog.get(type).add(singleCar);
        }

        String command = scanner.nextLine();
        Predicate<Car> filter = getPredicate(command);
        carInCatalog.get(command).stream().filter(Objects.requireNonNull(filter)).forEach(System.out::println);
    }

    private static Predicate<Car> getPredicate(String command) {
        switch (command) {
            case "flamable":
                return s -> s.getEngine().getEnginePower() > 250;

            case "fragile":
                return s -> s.getTire().getTireOnePressure() < 1 ||
                            s.getTire().getTireTwoPressure() < 1 ||
                            s.getTire().getTireThreePressure() < 1 ||
                            s.getTire().getTireFourPressure() < 1;
        }

        return null;
    }
}

/*
2
ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4
Citroen2CV 190 165 1200 fragile 0.9 3 0.85 2 0.95 2 1.1 1
fragile

4
ChevroletExpress 215 255 1200 flamable 2.5 1 2.4 2 2.7 1 2.8 1
ChevroletAstro 210 230 1000 flamable 2 1 1.9 2 1.7 3 2.1 1
DaciaDokker 230 275 1400 flamable 2.2 1 2.3 1 2.4 1 2 1
Citroen2CV 190 165 1200 fragile 0.8 3 0.85 2 0.7 5 0.95 2
flamable
 */
