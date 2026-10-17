package week_6.assignment_problems;

import java.util.Arrays;

public class GymMember {
    private static int membersEnrolled = 0;

    private final String memberId;
    private final int monthlyFee;
    public final String membershipNumber;

    private int sessionsAttended;
    private int feesPaid;
    private String lastPaymentMode = "";
    private final int[] lateFeeHistory = new int[10];
    private int lateFeeCount;
    private int totalLateFees;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException(
                    "memberId must contain at least 4 non-whitespace characters");
        }
        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("monthlyFee must be positive");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
        this.feesPaid = 0;
        this.lateFeeCount = 0;
        this.totalLateFees = 0;

        membersEnrolled++;
        this.membershipNumber = "GYM-" + (2000 + membersEnrolled);
    }

    // Constructor required for Problem 5.
    public GymMember(int monthlyFee) {
        this("AUTO", monthlyFee);
    }

    public String getMemberId() {
        return memberId;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public String getLastPaymentMode() {
        return lastPaymentMode;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    protected void chargeLateFee(int amount) {
        if (amount > 0 && lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount] = amount;
            lateFeeCount++;
            totalLateFees += amount;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);
    }

    public int getTotalLateFees() {
        return totalLateFees;
    }

    public void payFee(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive");
        }
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        if (mode == null || mode.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment mode cannot be blank");
        }
        lastPaymentMode = mode;
        payFee(amount);
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        if (memberIds == null) {
            return "Signed Up: 0 | Rejected: 0";
        }

        for (String id : memberIds) {
            try {
                new GymMember(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException exception) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }
        if (member instanceof PremiumMember) {
            return "Single inheritance (direct descendant)";
        }
        return "Base class";
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;

        if (members != null) {
            for (GymMember member : members) {
                if (member != null) {
                    total += member.getSessionsAttended();
                }
            }
        }

        return total;
    }

    public static String batchPrint(GymMember[] members) {
        StringBuilder announcement = new StringBuilder();

        if (members == null) {
            return "";
        }

        for (GymMember member : members) {
            if (member == null) {
                continue;
            }

            String info = member.displayInfo().replace("Standard Member", "Standard")
                    .replace("Premium Member", "Premium");

            announcement.append(info);

            if (member instanceof PremiumMember) {
                PremiumMember premium = (PremiumMember) member;
                announcement.append(" [Trainer via downcast: ")
                        .append(premium.getTrainerName())
                        .append("]");
            }

            announcement.append(" | ");
        }

        return announcement.toString();
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        if (members != null) {
            for (GymMember member : members) {
                if (member == null) {
                    nullSkipped++;
                    continue;
                }

                processed++;
                if (member instanceof GroupClassMember) {
                    groupCount++;
                } else {
                    individualCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | "
                + groupCount + " group | " + individualCount + " individual";
    }
}