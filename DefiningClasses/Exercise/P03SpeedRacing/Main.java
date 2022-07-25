package Advanced.DefiningClasses.Exercise.P03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carList = new LinkedHashMap<>();

        while (line-- > 0) {
            String[] token = scanner.nextLine().split("\\s+");
            Car singleCar = new Car(token[0], Double.parseDouble(token[1]), Double.parseDouble(token[2]));
            carList.put(token[0], singleCar);
        }

        String command;
        while (!"End".equals(command = scanner.nextLine())) {
            String carModel = command.split("\\s+")[1];
            double amountOfKm = Double.parseDouble(command.split("\\s+")[2]);
            Car temp = carList.get(carModel);
            temp.move(temp, amountOfKm);
        }

        carList.values().forEach(System.out::println);
    }
}

/*
2
AudiA4 23 0.3
BMW-M2 45 0.42
Drive BMW-M2 56
Drive AudiA4 5
Drive AudiA4 13
End

3
AudiA4 18 0.34
BMW-M2 33 0.41
Ferrari-488Spider 50 0.47
Drive Ferrari-488Spider 97
Drive Ferrari-488Spider 35
Drive AudiA4 85
Drive AudiA4 50
End
 */