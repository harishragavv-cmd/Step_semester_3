package week_8.class_problems;

public class MultipleChoiceQuestion extends ExamQuestion {
    private final String correctOption;

    public MultipleChoiceQuestion(String id, String text, int points, String correctOption) {
        super(id, text, points);
        if (correctOption == null || correctOption.trim().isEmpty()) {
            throw new IllegalArgumentException("Correct option is required");
        }
        this.correctOption = correctOption.trim();
    }

    @Override
    public boolean isCorrect(String answer) {
        return answer != null && correctOption.equalsIgnoreCase(answer.trim());
    }
}