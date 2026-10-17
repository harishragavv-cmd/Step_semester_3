package week_8.class_problems;

public class FullTimeEmployee extends LeaveEmployee {
    public FullTimeEmployee(String name) { super(name); }

    @Override
    protected int getMaximumConsecutiveLeaveDays() { return 20; }
}