package week_5.assignment_problems;

public class CirculationLedger {
    private static final String BRANCH_CODE;

    static {
        BRANCH_CODE = "PT-CENTRAL";
    }

    public static String getBranchCode() {
        return BRANCH_CODE;
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        if (receipts != null) {
            for (LoanReceipt receipt : receipts) {
                if (receipt == null) {
                    nullSkipped++;
                    continue;
                }

                processed++;
                if (receipt instanceof ReferenceOnlyLoanReceipt) {
                    referenceOnly++;
                } else {
                    regular++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | " + regular + " regular";
    }

    public static void main(String[] args) {
        LoanReceipt[] receipts = {
            new ReferenceOnlyLoanReceipt("LIB-001",
                    new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };

        System.out.println(processNightlyCirculation(receipts));
    }
}