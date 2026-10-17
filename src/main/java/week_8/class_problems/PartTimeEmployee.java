package week_8.class_problems;

public class PartTimeEmployee extends LeaveEmployee {
    public PartTimeEmployee(String name) { super(name); }

    @Override
    protected int getMaximumConsecutiveLeaveDays() { return 10; }
}