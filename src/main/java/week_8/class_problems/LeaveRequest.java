package week_8.class_problems;

import java.time.LocalDate;

public class LeaveRequest {
    private final LeaveEmployee employee;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private LeaveStatus status = LeaveStatus.PENDING;
    private String reviewer;

    LeaveRequest(LeaveEmployee employee, LocalDate startDate, LocalDate endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LeaveEmployee getEmployee() { return employee; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public LeaveStatus getStatus() { return status; }
    public String getReviewer() { return reviewer; }

    public String review(String reviewerName, boolean approve) {
        if (reviewerName == null || reviewerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Reviewer name is required");
        }
        if (status != LeaveStatus.PENDING) {
            return "Cannot review: request is already " + titleCase(status) + ".";
        }
        reviewer = reviewerName;
        status = approve ? LeaveStatus.APPROVED : LeaveStatus.REJECTED;
        return employee.getName() + "'s leave request (" + startDate + "-" + endDate + ") "
                + (approve ? "approved" : "rejected") + ". Status: " + titleCase(status) + ".";
    }

    public String attemptStatusChange(LeaveStatus requestedStatus) {
        if (requestedStatus == null) {
            return "Invalid leave status.";
        }
        if (status != LeaveStatus.PENDING && requestedStatus == LeaveStatus.PENDING) {
            return "Cannot change leave request status from " + titleCase(status) + " to Pending.";
        }
        if (requestedStatus != status) {
            return "Leave request status can only be changed by the review process.";
        }
        return "Leave request status remains " + titleCase(status) + ".";
    }

    private String titleCase(LeaveStatus value) {
        String text = value.name().toLowerCase();
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }
}