package week_6.assignment_problems;

import java.util.Arrays;

public class GymMembershipAssignmentDemo {
    public static void main(String[] args) {
        // Problem 1: Constructor validation and batch sign-up.
        System.out.println(GymMember.signUpBatch(
                new String[]{"MEM1", "GM1", "MEM2", " ", "MEM3"}, 1000));

        PremiumMember premium = new PremiumMember("MEM5", 2000, "Coach Riya");
        premium.attendSession();
        premium.attendSession();
        premium.attendSession();

        // Problem 2: Single, multilevel, and hierarchical inheritance.
        EliteMember elite = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        elite.attendSession();
        elite.attendSession();

        GroupClassMember group = new GroupClassMember("MEM4", 1500, "Zumba");
        group.attendSession();
        group.attendSession();
        group.attendSession();
        group.attendSession();

        System.out.println(new GymMember("MEM1", 1000).displayInfo());
        System.out.println(premium.displayInfo());
        System.out.println(elite.displayInfo());
        System.out.println(group.displayInfo());

        System.out.println(GymMember.classifyGeneration(elite));
        System.out.println(GymMember.classifyGeneration(group));
        System.out.println("Total sessions: " + GymMember.getTotalSessionsAttended(
                new GymMember[]{premium, elite, group}));

        // Problem 3: Premium discount and defensive copying of fee history.
        premium.chargeLateFee(200);
        int[] returnedHistory = premium.getLateFeeHistory();
        returnedHistory[0] = 999;
        System.out.println("Total late fees: " + premium.getTotalLateFees());
        System.out.println("Late-fee history: "
                + Arrays.toString(premium.getLateFeeHistory()));

        // Problem 4: One StringBuilder report and safe downcasting.
        System.out.println(GymMember.batchPrint(new GymMember[]{
                new GymMember("MEM6", 1000),
                new PremiumMember("MEM7", 2000, "Coach Riya")
        }));

        // Problem 5: Membership number, overloaded payment, referral and batch audit.
        GymMember automaticMember = new GymMember(1000);
        System.out.println(automaticMember.membershipNumber);
        System.out.println("Members enrolled: " + GymMember.getMembersEnrolled());

        automaticMember.payFee(500);
        automaticMember.payFee(500, "UPI");
        System.out.println("Fees paid: " + automaticMember.getFeesPaid());

        System.out.println(GymMember.isValidReferralCode("G45B"));
        System.out.println(GymMember.isValidReferralCode("G4B"));
        System.out.println(GymMember.isValidReferralCode("X45B"));

        System.out.println(GymMember.processWeeklyCheckIn(new GymMember[]{
                new GroupClassMember(1500, "Zumba"),
                null,
                new GymMember(1000)
        }));
    }
}