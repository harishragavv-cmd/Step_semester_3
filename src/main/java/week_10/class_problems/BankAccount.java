package week_10.class_problems;

public abstract class BankAccount {
    private final String accountId;
    protected double balance;

    protected BankAccount(String accountId, double initialBalance) {
        if (accountId == null || accountId.trim().isEmpty() || initialBalance <= 0) {
            throw new IllegalArgumentException("Account ID and positive initial balance are required");
        }
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public String getAccountId() { return accountId; }
    public double getBalance() { return balance; }

    protected abstract boolean canWithdraw(double amount);
    protected abstract String rejectionReason();

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(accountId + " rejected: withdrawal amount must be positive");
            return;
        }
        if (!canWithdraw(amount)) {
            System.out.println(accountId + " rejected: " + rejectionReason());
            return;
        }
        balance -= amount;
        System.out.println(accountId + " balance " + formatBalance(balance));
    }

    private String formatBalance(double value) {
        if (value == Math.rint(value)) return String.format("%.0f", value);
        return String.format("%.2f", value);
    }
}