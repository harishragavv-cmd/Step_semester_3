package week_10.class_problems;

import java.util.Locale;

public class ClassMarksGridAnalysis {

    public static void analyze(String[] names, int[][] marks) {
        if (names == null || marks == null || names.length == 0 || names.length != marks.length) {
            throw new IllegalArgumentException("Names and marks must have the same non-zero row count");
        }

        int subjects = 3;
        int[] subjectTotals = new int[subjects];
        int[] studentTotals = new int[names.length];
        int topperIndex = 0;

        for (int row = 0; row < marks.length; row++) {
            if (marks[row] == null || marks[row].length != subjects) {
                throw new IllegalArgumentException("Each student must have exactly 3 subject marks");
            }

            for (int col = 0; col < subjects; col++) {
                studentTotals[row] += marks[row][col];
                subjectTotals[col] += marks[row][col];
            }

            // Strictly greater preserves the first student when totals tie.
            if (studentTotals[row] > studentTotals[topperIndex]) {
                topperIndex = row;
            }
        }

        StringBuilder totalsOutput = new StringBuilder("Totals ");
        for (int i = 0; i < names.length; i++) {
            if (i > 0) totalsOutput.append(", ");
            totalsOutput.append(names[i]).append(" ").append(studentTotals[i]);
        }
        System.out.println(totalsOutput);

        System.out.printf(Locale.US, "averages %.2f, %.2f, %.2f%n",
                (double) subjectTotals[0] / names.length,
                (double) subjectTotals[1] / names.length,
                (double) subjectTotals[2] / names.length);

        System.out.println("topper " + names[topperIndex] + " (" + studentTotals[topperIndex] + ")");
    }

    public static void main(String[] args) {
        String[] names = {"Asha", "Ravi", "Neha"};
        int[][] marks = {
                {78, 85, 90},
                {88, 92, 79},
                {65, 70, 95}
        };
        analyze(names, marks);
    }
}