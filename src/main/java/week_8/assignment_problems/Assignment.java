package week_8.assignment_problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Assignment {
    private final String title;
    private final LocalDate dueDate;
    private final double maxMarks;

    public Assignment(String title, LocalDate dueDate, double maxMarks) {
        if (title == null || title.trim().isEmpty() || dueDate == null || maxMarks <= 0) {
            throw new IllegalArgumentException("Title, due date and positive max marks are required");
        }
        this.title = title;
        this.dueDate = dueDate;
        this.maxMarks = maxMarks;
    }

    public String getTitle() { return title; }
    public LocalDate getDueDate() { return dueDate; }
    public double getMaxMarks() { return maxMarks; }

    public int getLateDays(LocalDate submittedDate) {
        long days = ChronoUnit.DAYS.between(dueDate, submittedDate);
        return (int) Math.max(0, days);
    }

    public abstract double applyLatePenalty(double awardedMarks, int lateDays);

    public abstract double getDailyPenaltyPercent();
}