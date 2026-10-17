package week_8.assignment_problems;

import java.util.Locale;

public class Membership {
    private final GymMember member;
    private final MembershipPlan plan;
    private final double fee;
    private MembershipStatus status;

    public Membership(GymMember member, MembershipPlan plan) {
        if (member == null || plan == null) {
            throw new IllegalArgumentException("Member and plan are required");
        }
        this.member = member;
        this.plan = plan;
        this.fee = plan.calculateFee();
        this.status = MembershipStatus.ACTIVE;
    }

    public GymMember getMember() { return member; }
    public MembershipPlan getPlan() { return plan; }
    public double getFee() { return fee; }
    public MembershipStatus getStatus() { return status; }

    public String getFormattedFee() {
        return String.format(Locale.US, "₹%,.2f", fee);
    }

    public String checkIn() {
        if (status != MembershipStatus.ACTIVE) {
            return "Check-in denied: " + member.getName()
                    + "'s membership is " + titleCase(status) + ".";
        }
        return member.getName() + " checked in successfully.";
    }

    public String freeze() {
        if (status == MembershipStatus.EXPIRED) {
            return "Cannot freeze an Expired membership.";
        }
        if (status == MembershipStatus.FROZEN) {
            return member.getName() + "'s membership is already Frozen.";
        }

        status = MembershipStatus.FROZEN;
        return member.getName() + "'s membership frozen. Status: Frozen.";
    }

    public String unfreeze() {
        if (status == MembershipStatus.EXPIRED) {
            return "Cannot unfreeze an Expired membership.";
        }
        if (status == MembershipStatus.ACTIVE) {
            return member.getName() + "'s membership is already Active.";
        }

        status = MembershipStatus.ACTIVE;
        return member.getName() + "'s membership unfrozen. Status: Active.";
    }

    public String expire() {
        status = MembershipStatus.EXPIRED;
        return member.getName() + "'s membership expired. Status: Expired.";
    }

    private String titleCase(MembershipStatus currentStatus) {
        String lower = currentStatus.name().toLowerCase(Locale.ROOT);
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
}