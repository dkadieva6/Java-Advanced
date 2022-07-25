package Advanced.SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        Map<String, String> phonebook = new LinkedHashMap<>();
        while (!"search".equals(input = scanner.nextLine())) {
            String name = input.split("-")[0];
            String phoneNumber = input.split("-")[1];
            phonebook.put(name, phoneNumber);
        }

        while (!"stop".equals(input = scanner.nextLine())) {
            if (phonebook.containsKey(input)) {
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }
        }
    }
}
