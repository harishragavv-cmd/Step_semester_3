package week_8.class_problems;

public class OrderItem {
    private final ShoppingProduct product;
    private final int quantity;

    public OrderItem(ShoppingProduct product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Product and positive quantity are required");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public ShoppingProduct getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getLineTotal() { return product.getPrice() * quantity; }
}