package week_8.class_problems;

import java.util.HashMap;
import java.util.Map;

public class ExamStudent {
    private final String name;
    private final Map<String, ExamAttempt> attempts = new HashMap<>();

    public ExamStudent(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be blank");
        }
        this.name = name;
    }

    public String getName() { return name; }

    public ExamAttempt startExam(Examination exam) {
        if (exam == null) throw new IllegalArgumentException("Exam is required");
        ExamAttempt previous = attempts.get(exam.getExamId());
        if (previous != null) {
            if (previous.isSubmitted()) {
                System.out.println("Cannot start another attempt: " + exam.getTitle()
                        + " was already submitted by " + name + ".");
                return null;
            }
            return previous;
        }

        ExamAttempt attempt = new ExamAttempt(this, exam);
        attempts.put(exam.getExamId(), attempt);
        System.out.println(exam.getTitle() + " started by " + name + ".");
        return attempt;
    }
}