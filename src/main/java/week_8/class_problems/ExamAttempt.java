package week_8.class_problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExamAttempt {
    private final ExamStudent student;
    private final Examination examination;
    private final Map<ExamQuestion, ExamAnswer> answers = new LinkedHashMap<>();
    private boolean submitted;
    private int totalScore;

    ExamAttempt(ExamStudent student, Examination examination) {
        this.student = student;
        this.examination = examination;
    }

    public ExamStudent getStudent() { return student; }
    public Examination getExamination() { return examination; }
    public boolean isSubmitted() { return submitted; }
    public int getTotalScore() { return totalScore; }

    public boolean recordAnswer(ExamQuestion question, String response) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return false;
        }
        if (!examination.containsQuestion(question)) {
            System.out.println("Cannot record answer: question is not part of this examination.");
            return false;
        }
        answers.put(question, new ExamAnswer(question, response));
        System.out.println("Answer recorded for " + question.getQuestionId() + ".");
        return true;
    }

    public void submit() {
        if (submitted) {
            System.out.println("This examination has already been submitted.");
            return;
        }

        submitted = true;
        System.out.println(examination.getTitle() + " submitted by " + student.getName() + ".");
        totalScore = 0;
        for (ExamQuestion question : examination.getQuestions()) {
            ExamAnswer answer = answers.get(question);
            boolean correct = answer != null && answer.isCorrect();
            int points = correct ? question.getPoints() : 0;
            totalScore += points;
            System.out.println("Result: " + question.getQuestionId() + ": "
                    + (correct ? "Correct" : "Incorrect") + " (" + points + " points).");
        }
        System.out.println("Total score: " + totalScore + "/" + examination.getMaximumScore() + ".");
    }
}