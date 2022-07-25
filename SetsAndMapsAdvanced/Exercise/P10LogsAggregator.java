package Advanced.SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLines = Integer.parseInt(scanner.nextLine());
        Map<String, TreeMap<String, Integer>> users = new TreeMap<>();
        for (int i = 0; i < inputLines; i++) {
            String[] attributes = scanner.nextLine().split("\\s+");
            String ip = attributes[0];
            String user = attributes[1];
            int duration = Integer.parseInt(attributes[2]);

            users.putIfAbsent(user, new TreeMap<>());
            users.get(user).putIfAbsent(ip, 0);
            users.get(user).put(ip, users.get(user).get(ip) + duration);
        }

        users.forEach((key, value) ->
                System.out.printf("%s: %d [%s]%n",
                        key,
                        value.values().stream().mapToInt(i -> i).sum(),
                        value.keySet()
                                .stream()
                                .map(ip -> String.format("%s", ip))
                                .collect(Collectors.joining(", ")))
        );
    }
}
