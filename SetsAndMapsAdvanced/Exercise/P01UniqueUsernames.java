package Advanced.SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLine = Integer.parseInt(scanner.nextLine());
        Set<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < inputLine; i++) {
            String inputToAdd = scanner.nextLine();
            usernames.add(inputToAdd);
        }

        for (String username : usernames) {
            System.out.println(username);
        }

    }
}
