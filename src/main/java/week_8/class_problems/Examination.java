package week_8.class_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Examination {
    private final String examId;
    private final String title;
    private final List<ExamQuestion> questions;

    public Examination(String examId, String title, List<ExamQuestion> questions) {
        if (examId == null || examId.trim().isEmpty() || title == null || title.trim().isEmpty()
                || questions == null || questions.isEmpty()) {
            throw new IllegalArgumentException("Exam ID, title and at least one question are required");
        }
        this.examId = examId;
        this.title = title;
        this.questions = Collections.unmodifiableList(new ArrayList<>(questions));
    }

    public String getExamId() { return examId; }
    public String getTitle() { return title; }
    public List<ExamQuestion> getQuestions() { return questions; }
    public boolean containsQuestion(ExamQuestion question) { return questions.contains(question); }

    public int getMaximumScore() {
        int total = 0;
        for (ExamQuestion question : questions) total += question.getPoints();
        return total;
    }
}