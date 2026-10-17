package week_8.class_problems;

public class ShortAnswerQuestion extends ExamQuestion {
    private final String expectedAnswer;

    public ShortAnswerQuestion(String id, String text, int points, String expectedAnswer) {
        super(id, text, points);
        if (expectedAnswer == null || expectedAnswer.trim().isEmpty()) {
            throw new IllegalArgumentException("Expected answer is required");
        }
        this.expectedAnswer = expectedAnswer.trim();
    }

    @Override
    public boolean isCorrect(String answer) {
        return answer != null && expectedAnswer.equalsIgnoreCase(answer.trim());
    }
}