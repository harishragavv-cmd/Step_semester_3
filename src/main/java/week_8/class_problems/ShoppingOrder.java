package week_8.class_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingOrder {
    private final String orderId;
    private final ShoppingCustomer customer;
    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.PENDING;

    ShoppingOrder(String orderId, ShoppingCustomer customer) {
        if (orderId == null || orderId.trim().isEmpty() || customer == null) {
            throw new IllegalArgumentException("Order ID and customer are required");
        }
        this.orderId = orderId;
        this.customer = customer;
        System.out.println("Order created for " + customer.getName() + ".");
    }

    public String getOrderId() { return orderId; }
    public ShoppingCustomer getCustomer() { return customer; }
    public OrderStatus getStatus() { return status; }
    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(new ArrayList<>(items));
    }

    public void addProduct(ShoppingProduct product, int quantity) {
        if (status == OrderStatus.PAID) {
            throw new IllegalStateException("Cannot add items to a paid order");
        }
        items.add(new OrderItem(product, quantity));
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) total += item.getLineTotal();
        return total;
    }

    public boolean payWith(PaymentMethod method) {
        if (method == null) {
            throw new IllegalArgumentException("Payment method is required");
        }
        if (items.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return false;
        }
        if (status == OrderStatus.PAID) {
            System.out.println("Order " + orderId + " is already Paid.");
            return false;
        }

        System.out.println("Payment initiated via " + method.getMethodName()
                + " for " + orderId + ".");
        boolean succeeded = method.processPayment(this, getTotal());
        if (succeeded) {
            status = OrderStatus.PAID;
            System.out.println("Payment for " + orderId + " successful. Order status: Paid.");
        } else {
            System.out.println("Payment for " + orderId + " failed. Order status: Pending.");
        }
        return succeeded;
    }
}