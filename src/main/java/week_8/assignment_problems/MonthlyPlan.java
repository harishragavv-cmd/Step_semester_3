package week_8.assignment_problems;

public class MonthlyPlan implements MembershipPlan {
    public String getName() { return "Monthly"; }
    public int getMonths() { return 1; }
    public double calculateFee() { return 1000.0; }
}