package week_8.class_problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class LeaveEmployee {
    private final String name;

    protected LeaveEmployee(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be blank");
        }
        this.name = name;
    }

    public String getName() { return name; }

    protected abstract int getMaximumConsecutiveLeaveDays();

    public boolean isLeavePeriodAllowed(LocalDate start, LocalDate end) {
        if (start == null || end == null || end.isBefore(start)) {
            return false;
        }
        long days = ChronoUnit.DAYS.between(start, end) + 1;
        return days <= getMaximumConsecutiveLeaveDays();
    }

    public LeaveRequest submitLeave(LocalDate start, LocalDate end) {
        if (!isLeavePeriodAllowed(start, end)) {
            System.out.println("Leave request rejected at submission: invalid dates or leave policy limit exceeded for "
                    + name + ".");
            return null;
        }
        LeaveRequest request = new LeaveRequest(this, start, end);
        System.out.println("Leave request submitted for " + name + " (" + start + "-" + end
                + "). Status: Pending.");
        return request;
    }
}