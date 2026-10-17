package week_10.class_problems;

public class FullTimeStaff extends Staff {
    private final double monthlySalary;

    public FullTimeStaff(String name, double monthlySalary) {
        super(name);
        if (monthlySalary < 0) throw new IllegalArgumentException("Salary cannot be negative");
        this.monthlySalary = monthlySalary;
    }

    @Override public String getType() { return "FullTime"; }
    @Override public double calculatePay() { return monthlySalary; }
}