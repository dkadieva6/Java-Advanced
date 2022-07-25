package Advanced.DefiningClasses.Exercise.P02CompanyRoster;

public class Employee {
    String name;
    double salary;
    String position;
    String department;
    String email = "n/a";
    int age = -1;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this(name, salary, position, department);
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.email = email;
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }
}
