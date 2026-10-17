package week_8.class_problems;

public interface PaymentMethod {
    String getMethodName();
    boolean processPayment(ShoppingOrder order, double amount);
}