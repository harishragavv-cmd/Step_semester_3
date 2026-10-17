package week_8.class_problems;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public String getMethodName() { return "Credit Card"; }

    @Override
    public boolean processPayment(ShoppingOrder order, double amount) {
        // Simulates an accepted credit-card transaction.
        return order != null && amount > 0;
    }
}