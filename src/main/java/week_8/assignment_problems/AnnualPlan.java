package week_8.assignment_problems;

public class AnnualPlan implements MembershipPlan {
    public String getName() { return "Annual"; }
    public int getMonths() { return 12; }
    public double calculateFee() { return 1000.0 * 12 * 0.75; }
}