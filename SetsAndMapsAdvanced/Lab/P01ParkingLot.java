package Advanced.SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        Set<String> cars = new LinkedHashSet<>();
        while(!"END".equals(input = scanner.nextLine())) {
            String[] commandAttribute = input.split(",\\s+");
            String carNumber = commandAttribute[1];
            switch (commandAttribute[0]) {
                case "IN":
                    cars.add(carNumber);
                    break;

                case "OUT":
                    cars.remove(carNumber);
                    break;
            }
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }

        }
    }
}
