package week_1.assigment_problems;
import java.util.Scanner;

public class MovieReviewWordLengthProfiler {
    static void classifyWordLengths(String review) {
        int shortWords = 0, mediumWords = 0, longWords = 0;
        String[] words = review.trim().isEmpty() ? new String[0] : review.trim().split("\\s+");
        for (String word : words) {
            String cleaned = word.replaceAll("[^a-zA-Z]", "");
            int length = cleaned.length();
            if (length == 0) continue;
            if (length <= 4) shortWords++;
            else if (length <= 8) mediumWords++;
            else longWords++;
        }
        System.out.println("Short: " + shortWords + " | Medium: " + mediumWords + " | Long: " + longWords);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter movie review: ");
        classifyWordLengths(sc.nextLine());
        sc.close();
    }
}