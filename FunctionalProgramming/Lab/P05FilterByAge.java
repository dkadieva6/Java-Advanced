package Advanced.FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> peopleWithAge = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split(",\\s+");
            peopleWithAge.put(personData[0], Integer.parseInt(personData[1]));
        }

        //"younger" ot "older"
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        //"name", "age", or "name age"
        String format = scanner.nextLine();

        BiPredicate<Integer, Integer> filterAge;
        if ("younger".equals(condition)) {
            filterAge = (personAge, ageLimit) -> personAge <= ageLimit;
        } else {
            filterAge = (personAge, ageLimit) -> personAge >= ageLimit;
        }

        Consumer<Map.Entry<String, Integer>> printPersonData;

        switch (format) {
            case "name":
                printPersonData = person -> System.out.println(person.getKey());
                break;

            case "age":
                printPersonData = person -> System.out.println(person.getValue());
                break;

            case "name age":
                printPersonData = person -> System.out.println(person.getKey() + " - " + person.getValue());
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + format);
        }

        peopleWithAge.entrySet()
                .stream()
                .filter("younger".equals(condition) ? i -> i.getValue() <= age : i -> i.getValue() >= age)
                .filter(person -> filterAge.test(person.getValue(), age))
                .forEach(printPersonData);
    }
}
