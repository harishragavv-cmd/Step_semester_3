package week_8.assignment_problems;

import java.time.LocalDate;

public class Submission {
    private final PortalStudent student;
    private final Assignment assignment;
    private LocalDate submittedDate;
    private SubmissionStatus status = SubmissionStatus.NOT_SUBMITTED;
    private double finalMarks;

    public Submission(PortalStudent student, Assignment assignment) {
        if (student == null || assignment == null) {
            throw new IllegalArgumentException("Student and assignment are required");
        }
        this.student = student;
        this.assignment = assignment;
    }

    public boolean submit(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Submission date is required");
        }
        if (status == SubmissionStatus.GRADED) {
            return false;
        }

        this.submittedDate = date;
        this.status = SubmissionStatus.SUBMITTED;
        return true;
    }

    public double grade(double awardedMarks) {
        if (status != SubmissionStatus.SUBMITTED) {
            throw new IllegalStateException("A submission must be submitted before grading");
        }
        if (awardedMarks < 0 || awardedMarks > assignment.getMaxMarks()) {
            throw new IllegalArgumentException("Awarded marks must be within the assignment's range");
        }

        int lateDays = assignment.getLateDays(submittedDate);
        finalMarks = assignment.applyLatePenalty(awardedMarks, lateDays);
        status = SubmissionStatus.GRADED;
        return finalMarks;
    }

    public PortalStudent getStudent() { return student; }
    public Assignment getAssignment() { return assignment; }
    public LocalDate getSubmittedDate() { return submittedDate; }
    public SubmissionStatus getStatus() { return status; }
    public double getFinalMarks() { return finalMarks; }
    public int getLateDays() {
        return submittedDate == null ? 0 : assignment.getLateDays(submittedDate);
    }
}