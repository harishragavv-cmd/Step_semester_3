package week_8.class_problems;

import java.util.Arrays;

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        ExamStudent student = new ExamStudent("Student 1");
        ExamQuestion q1 = new MultipleChoiceQuestion(
                "Question 1", "Which option is correct?", 5, "C");
        ExamQuestion q2 = new TrueFalseQuestion(
                "Question 2", "Java is only a procedural language.", 5, false);
        Examination exam = new Examination("EX-A", "Exam A", Arrays.asList(q1, q2));

        ExamAttempt attempt = student.startExam(exam);
        attempt.recordAnswer(q1, "C");
        attempt.recordAnswer(q2, "True");
        attempt.submit();
        attempt.recordAnswer(q1, "A");
    }
}