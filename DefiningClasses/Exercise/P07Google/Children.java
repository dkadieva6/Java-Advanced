package Advanced.DefiningClasses.Exercise.P07Google;

public class Children {
    private String name;
    private String dateOfBirth;

    public Children(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.dateOfBirth);
    }
}
