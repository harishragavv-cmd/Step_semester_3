package week_8.assignment_problems;

public class LaundryStudent {
    private final String name;

    public LaundryStudent(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}