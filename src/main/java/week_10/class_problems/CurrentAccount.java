package week_10.class_problems;

public class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 5000.0;

    public CurrentAccount(String accountId, double initialBalance) {
        super(accountId, initialBalance);
    }

    @Override
    protected boolean canWithdraw(double amount) {
        return balance - amount >= -OVERDRAFT_LIMIT;
    }

    @Override
    protected String rejectionReason() {
        return "overdraft limit 5000";
    }
}