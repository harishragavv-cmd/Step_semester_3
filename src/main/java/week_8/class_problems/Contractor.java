package week_8.class_problems;

public class Contractor extends LeaveEmployee {
    public Contractor(String name) { super(name); }

    @Override
    protected int getMaximumConsecutiveLeaveDays() { return 5; }
}