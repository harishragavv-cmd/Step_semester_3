package week_10.class_problems;

public class SavingsAccount extends BankAccount {
    private static final double MINIMUM_BALANCE = 1000.0;

    public SavingsAccount(String accountId, double initialBalance) {
        super(accountId, initialBalance);
    }

    @Override
    protected boolean canWithdraw(double amount) {
        return balance - amount >= MINIMUM_BALANCE;
    }

    @Override
    protected String rejectionReason() {
        return "minimum balance 1000";
    }
}