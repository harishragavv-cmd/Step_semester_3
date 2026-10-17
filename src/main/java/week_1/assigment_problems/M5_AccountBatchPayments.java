package week_1.assigment_problems;

class FeeAccount {
    public void processPayment(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

class HostelFeeAccount extends FeeAccount {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}

public class M5_AccountBatchPayments {
    public static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            account.processPayment(amount);
        } else {
            account.processPayment(amount);
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        int hostelCount = 0;
        int dayScholarCount = 0;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayScholarCount++;
            }
            processPayment(accounts[i], 60000);
        }

        System.out.println("Hostel accounts processed: " + hostelCount
                + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}