package week_8.class_problems;

public class ShoppingProduct {
    private final String name;
    private final double price;

    public ShoppingProduct(String name, double price) {
        if (name == null || name.trim().isEmpty() || price < 0) {
            throw new IllegalArgumentException("Product name and non-negative price are required");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}