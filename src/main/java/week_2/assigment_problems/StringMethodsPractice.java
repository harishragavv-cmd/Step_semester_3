package week_2.assigment_problems;
import java.util.Scanner;

public class StringMethodsPractice {
    static void analyzeString(String text) {
        String cleaned = text.trim();
        System.out.println("Length: " + cleaned.length());
        if (!cleaned.isEmpty()) {
            System.out.println("First Character: " + cleaned.charAt(0));
            System.out.println("Last Character: " + cleaned.charAt(cleaned.length() - 1));
            System.out.println("Uppercase: " + cleaned.toUpperCase());
            System.out.println("Lowercase: " + cleaned.toLowerCase());
            System.out.println("Substring (first up to 3 chars): "
                    + cleaned.substring(0, Math.min(3, cleaned.length())));
            System.out.println("Index of 'a': " + cleaned.indexOf('a'));
            System.out.println("Replace spaces: " + cleaned.replace(" ", "-"));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        analyzeString(sc.nextLine());
        sc.close();
    }
}