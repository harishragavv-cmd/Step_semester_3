package week_8.class_problems;

public class RentalCustomer {
    private final String name;

    public RentalCustomer(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}