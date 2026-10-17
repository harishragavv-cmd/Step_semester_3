package week_8.assignment_problems;

public class TicketCustomer {
    private final String name;

    public TicketCustomer(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}