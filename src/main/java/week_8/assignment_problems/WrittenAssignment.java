package week_8.assignment_problems;

import java.time.LocalDate;

public class WrittenAssignment extends Assignment {
    public WrittenAssignment(String title, LocalDate dueDate, double maxMarks) {
        super(title, dueDate, maxMarks);
    }

    @Override
    public double applyLatePenalty(double awardedMarks, int lateDays) {
        double penaltyRate = Math.min(1.0, lateDays * 0.20);
        return awardedMarks * (1.0 - penaltyRate);
    }

    @Override
    public double getDailyPenaltyPercent() {
        return 20.0;
    }
}