package Advanced.SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        Map<String, String> emails = new LinkedHashMap<>();
        while (!"stop".equals(input = scanner.nextLine())) {
            String email = scanner.nextLine();
            String domain = email.substring(email.lastIndexOf(".") + 1);

            if (!("us".equals(domain) || "uk".equals(domain) || "com".equals(domain))) {
                emails.put(input, email);
            }
        }

        emails.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
