package week_8.class_problems;

public class PayPalPayment implements PaymentMethod {
    private final boolean transactionSucceeds;

    public PayPalPayment(boolean transactionSucceeds) {
        this.transactionSucceeds = transactionSucceeds;
    }

    @Override
    public String getMethodName() { return "PayPal"; }

    @Override
    public boolean processPayment(ShoppingOrder order, double amount) {
        // The flag simulates the result returned by an external payment provider.
        return transactionSucceeds && order != null && amount > 0;
    }
}