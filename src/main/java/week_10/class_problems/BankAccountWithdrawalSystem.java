package week_10.class_problems;

import java.util.HashMap;
import java.util.Map;

public class BankAccountWithdrawalSystem {
    private final Map<String, BankAccount> accounts = new HashMap<>();

    public void addAccount(BankAccount account) {
        if (account == null) throw new IllegalArgumentException("Account is required");
        accounts.put(account.getAccountId(), account);
    }

    public void withdraw(String accountId, double amount) {
        BankAccount account = accounts.get(accountId);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }
        account.withdraw(amount);
    }

    public static void main(String[] args) {
        BankAccountWithdrawalSystem system = new BankAccountWithdrawalSystem();
        system.addAccount(new SavingsAccount("S1", 5000));
        system.withdraw("S1", 4500);

        system.addAccount(new CurrentAccount("C1", 2000));
        system.withdraw("C1", 6000);
        system.withdraw("S1", 3000);
        system.withdraw("C1", 2000);
    }
}