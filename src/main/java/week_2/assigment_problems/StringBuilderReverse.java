package week_2.assigment_problems;
import java.util.Scanner;

public class StringBuilderReverse {
    static String reverseText(String text) {
        StringBuilder builder = new StringBuilder(text);
        return builder.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.println("Original: " + text);
        System.out.println("Reversed: " + reverseText(text));
        sc.close();
    }
}