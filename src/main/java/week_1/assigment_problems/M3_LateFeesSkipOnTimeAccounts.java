package week_1.assigment_problems;

class FeeRecord {
    private String regNo;
    private double totalFee;
    private static final double DAILY_LATE_FEE_RATE = 0.01;

    public FeeRecord(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    public final double calculateLateFee(int daysLate) {
        if (daysLate <= 0) {
            return 0;
        }
        return totalFee * DAILY_LATE_FEE_RATE * daysLate;
    }

    public final void printSummary(int daysLate) {
        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
        } else {
            System.out.println(regNo + " | Total Fee: Rs " + totalFee
                    + " | Late Fee: Rs " + calculateLateFee(daysLate));
        }
    }
}

public class M3_LateFeesSkipOnTimeAccounts {
    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        for (int i = 0; i < regNos.length; i++) {
            FeeRecord record = new FeeRecord(regNos[i], totalFees[i]);
            record.printSummary(daysLate[i]);
        }
    }
}