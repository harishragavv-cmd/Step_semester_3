package week_8.class_problems;

public class BankTransferPayment implements PaymentMethod {
    private final boolean transferSucceeds;

    public BankTransferPayment(boolean transferSucceeds) {
        this.transferSucceeds = transferSucceeds;
    }

    @Override
    public String getMethodName() { return "Bank Transfer"; }

    @Override
    public boolean processPayment(ShoppingOrder order, double amount) {
        return transferSucceeds && order != null && amount > 0;
    }
}