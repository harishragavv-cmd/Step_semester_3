package week_9.assignment_problems;

import java.util.Arrays;
import java.util.List;

public class ClassTopperFinder {

    // Returns {rowIndex, totalMarks}. If totals tie, keeps the earliest row.
    public static int[] findTopper(List<List<Integer>> marks) {
        if (marks == null || marks.isEmpty()) {
            throw new IllegalArgumentException("Marks must contain at least one student");
        }

        int bestRow = 0;
        int bestTotal = -1;

        for (int i = 0; i < marks.size(); i++) {
            int total = 0;
            for (int mark : marks.get(i)) {
                if (mark < 0) {
                    throw new IllegalArgumentException("Marks cannot be negative");
                }
                total += mark;
            }

            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }

        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        List<List<Integer>> marks = Arrays.asList(
                Arrays.asList(78, 85, 90),
                Arrays.asList(88, 92, 79),
                Arrays.asList(65, 70, 95)
        );

        int[] result = findTopper(marks);
        System.out.println("(" + result[0] + ", " + result[1] + ")");
    }
}