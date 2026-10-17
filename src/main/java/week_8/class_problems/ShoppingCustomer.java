package week_8.class_problems;

public class ShoppingCustomer {
    private final String name;

    public ShoppingCustomer(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be blank");
        }
        this.name = name;
    }

    public String getName() { return name; }

    public ShoppingOrder createOrder(String orderId) {
        return new ShoppingOrder(orderId, this);
    }
}