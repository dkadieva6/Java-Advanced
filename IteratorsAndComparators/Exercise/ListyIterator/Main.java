package ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        ListyIterator current = null;

        while (!"END".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    current = new ListyIterator(Arrays.copyOfRange(tokens, 1, tokens.length));
                    break;

                case "Move":
                    System.out.println(current.Move());
                    break;

                case "Print":
                    current.Print();
                    break;

                case "HasNext":
                    System.out.println(current.hasNext());
                    break;
            }
        }
    }
}
