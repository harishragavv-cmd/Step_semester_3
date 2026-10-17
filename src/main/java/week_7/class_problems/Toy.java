package week_7.class_problems;

public abstract class Toy {
    private static int nextId = 1000;

    private final String toyId;
    protected final String name;

    public Toy(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Toy name cannot be blank");
        }

        this.name = name;
        nextId++;
        this.toyId = "TOY-" + nextId;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }
}