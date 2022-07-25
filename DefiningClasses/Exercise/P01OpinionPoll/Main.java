package Advanced.DefiningClasses.Exercise.P01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        while (line-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person singlePerson = new Person(tokens[0], Integer.parseInt(tokens[1]));
            people.add(singlePerson);
        }

        people.stream().filter(s -> s.getAge() > 30).sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
    }
}
/*
3
Peter 12
Steven 31
John 48

5
Sofia 33
Thomas 88
Camilla 22
Robert 44
Owen 11
 */