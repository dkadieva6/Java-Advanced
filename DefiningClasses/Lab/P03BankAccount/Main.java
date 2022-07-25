package Advanced.DefiningClasses.Lab.P03BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        Map<Integer, BankAccount> bankAccounts = new HashMap<>();
        String error = "Account does not exist";

        while (!"End".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    int id = bankAccount.getId();
                    bankAccounts.put(id, bankAccount);
                    break;

                case "Deposit":
                    id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    if (bankAccounts.containsKey(id)) {
                        bankAccounts.get(id).deposit(amount, id);
                    } else {
                        System.out.println(error);
                    }
                    break;

                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterest(interest);
                    break;

                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (bankAccounts.containsKey(id)) {
                        System.out.printf("%.2f%n", bankAccounts.get(id).getInterest(id, years));
                    } else {
                        System.out.println(error);
                    }
                    break;
            }
        }
    }
}
/*
Create
Create
Deposit 1 20
Deposit 1 20
Deposit 3 20
Deposit 2 10
SetInterest 1.5
GetInterest 1 1
GetInterest 2 1
GetInterest 3 1
End
 */