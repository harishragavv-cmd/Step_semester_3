package week_8.assignment_problems;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class PortalStudent {
    private final String name;
    private final Map<String, Submission> submissions = new LinkedHashMap<>();

    public PortalStudent(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be blank");
        }
        this.name = name;
    }

    public String getName() { return name; }

    public Submission submitAssignment(Assignment assignment, LocalDate date) {
        Submission existing = submissions.get(assignment.getTitle());
        if (existing != null && existing.getStatus() == SubmissionStatus.GRADED) {
            System.out.println("Cannot resubmit: '" + assignment.getTitle()
                    + "' has already been graded.");
            return null;
        }

        Submission submission = existing;
        if (submission == null) {
            submission = new Submission(this, assignment);
            submissions.put(assignment.getTitle(), submission);
        }

        if (!submission.submit(date)) {
            System.out.println("Cannot resubmit: '" + assignment.getTitle()
                    + "' has already been graded.");
            return null;
        }

        int lateDays = submission.getLateDays();
        if (lateDays == 0) {
            System.out.println(name + "'s submission for '" + assignment.getTitle()
                    + "' received (on time). Status: Submitted.");
        } else {
            System.out.println(name + "'s submission for '" + assignment.getTitle()
                    + "' received (" + lateDays + " days late). Status: Submitted.");
        }
        return submission;
    }

    public Submission getSubmission(String assignmentTitle) {
        return submissions.get(assignmentTitle);
    }
}