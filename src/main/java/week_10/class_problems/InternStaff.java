package week_10.class_problems;

public class InternStaff extends Staff {
    private final double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        if (stipend < 0) throw new IllegalArgumentException("Stipend cannot be negative");
        this.stipend = stipend;
    }

    @Override public String getType() { return "Intern"; }
    @Override public double calculatePay() { return stipend; }
}