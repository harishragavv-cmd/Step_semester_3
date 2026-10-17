package week_8.class_problems;

public abstract class ExamQuestion {
    private final String questionId;
    private final String text;
    private final int points;

    protected ExamQuestion(String questionId, String text, int points) {
        if (questionId == null || questionId.trim().isEmpty()
                || text == null || text.trim().isEmpty() || points <= 0) {
            throw new IllegalArgumentException("Question ID, text and positive points are required");
        }
        this.questionId = questionId;
        this.text = text;
        this.points = points;
    }

    public String getQuestionId() { return questionId; }
    public String getText() { return text; }
    public int getPoints() { return points; }
    public abstract boolean isCorrect(String answer);
}