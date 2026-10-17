package week_8.class_problems;

public class ExamAnswer {
    private final ExamQuestion question;
    private final String response;

    public ExamAnswer(ExamQuestion question, String response) {
        if (question == null) {
            throw new IllegalArgumentException("Question is required");
        }
        this.question = question;
        this.response = response == null ? "" : response.trim();
    }

    public ExamQuestion getQuestion() { return question; }
    public String getResponse() { return response; }
    public boolean isCorrect() { return question.isCorrect(response); }
    public int getAwardedPoints() { return isCorrect() ? question.getPoints() : 0; }
}