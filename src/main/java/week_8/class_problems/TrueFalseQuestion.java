package week_8.class_problems;

public class TrueFalseQuestion extends ExamQuestion {
    private final boolean correctAnswer;

    public TrueFalseQuestion(String id, String text, int points, boolean correctAnswer) {
        super(id, text, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean isCorrect(String answer) {
        return answer != null && Boolean.toString(correctAnswer).equalsIgnoreCase(answer.trim());
    }
}