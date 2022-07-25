package Advanced.DefiningClasses.Exercise.P02CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int line = Integer.parseInt(console.nextLine());
        Map<String, Department> departmentList = new HashMap<>();
        while (line-- > 0){
            String[] token = console.nextLine().split("\\s+");
            Employee singleEmployee = null;
            String name = token[0];
            double salary = Double.parseDouble(token[1]);
            String position = token[2];
            String department = token[3];

            if(token.length==4) {
                singleEmployee = new Employee(name, salary, position, department);

            }
            if(token.length==6) {
                singleEmployee = new Employee(name, salary, position, department, token[4], Integer.parseInt(token[5]));

            }
            if(token.length==5) {
                if(token[4].chars().allMatch(Character::isDigit)){
                    singleEmployee = new Employee(name, salary, position, department, Integer.parseInt(token[4]));
                } else {
                    singleEmployee = new Employee(name, salary, position, department, token[4]);
                }
            }

            departmentList.putIfAbsent(department, new Department(department));
            Department temp = departmentList.get(department);
            temp.updateSell(temp, salary, singleEmployee);
        }
        Optional<Department> temp = departmentList.values().stream().max(Comparator.comparing(Department::getAverageSalary));
        System.out.println("Highest Average Salary: " + temp.get().getName());
        temp.get().getDepartmentEmployers().stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);
    }
}

/*
4
Peter 120.00 Dev Development peter@abv.bg 28
Tina 333.33 Manager Marketing 33
Sam 840.20 ProjectLeader Development sam@sam.com
George 0.20 Freeloader Nowhere 18

6
Silver 496.37 Temp Coding silver@yahoo.com
Sam 610.13 Manager Sales
John 609.99 Manager Sales john@abv.bg 44
Venci 0.02 Director BeerDrinking beer@beer.br 23
Andre 700.00 Director Coding
Popeye 13.3333 Sailor SpinachGroup popeye@pop.ey
*/