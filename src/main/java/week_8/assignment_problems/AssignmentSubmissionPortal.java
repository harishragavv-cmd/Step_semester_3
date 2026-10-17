package week_8.assignment_problems;

import java.time.LocalDate;
import java.util.Locale;

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        Assignment coding = new CodingAssignment(
                "Linked List Lab", LocalDate.of(2026, 3, 10), 50);
        Assignment written = new WrittenAssignment(
                "Design Essay", LocalDate.of(2026, 3, 12), 50);

        PortalStudent asha = new PortalStudent("Asha");
        PortalStudent ravi = new PortalStudent("Ravi");

        Submission ashaSubmission = asha.submitAssignment(
                coding, LocalDate.of(2026, 3, 10));
        Submission raviSubmission = ravi.submitAssignment(
                written, LocalDate.of(2026, 3, 14));

        double ashaMarks = ashaSubmission.grade(45);
        System.out.println("Asha graded: " + formatMarks(ashaMarks) + "/50. Status: Graded.");

        double raviMarks = raviSubmission.grade(40);
        double penaltyPercent = raviSubmission.getLateDays()
                * written.getDailyPenaltyPercent();
        System.out.println("Ravi graded: " + formatMarks(raviMarks)
                + "/50 after " + formatMarks(penaltyPercent)
                + "% late penalty. Status: Graded.");

        asha.submitAssignment(coding, LocalDate.of(2026, 3, 11));
    }

    private static String formatMarks(double value) {
        if (Math.abs(value - Math.round(value)) < 0.000001) {
            return String.format(Locale.US, "%.0f", value);
        }
        return String.format(Locale.US, "%.2f", value);
    }
}