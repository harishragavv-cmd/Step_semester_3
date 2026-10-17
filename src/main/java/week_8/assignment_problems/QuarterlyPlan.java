package week_8.assignment_problems;

public class QuarterlyPlan implements MembershipPlan {
    public String getName() { return "Quarterly"; }
    public int getMonths() { return 3; }
    public double calculateFee() { return 1000.0 * 3 * 0.90; }
}