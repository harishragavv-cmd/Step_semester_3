package week_10.class_problems;

public abstract class Staff {
    private final String name;

    protected Staff(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Staff name cannot be blank");
        }
        this.name = name;
    }

    public String getName() { return name; }
    public abstract String getType();
    public abstract double calculatePay();
}