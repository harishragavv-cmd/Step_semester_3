package week_2.assigment_problems;
import java.util.Scanner;

public class StringComparisonPractice {
    static void compareStrings(String first, String second) {
        System.out.println("Using equals(): " + first.equals(second));
        System.out.println("Ignoring case: " + first.equalsIgnoreCase(second));
        System.out.println("Using compareTo(): " + first.compareTo(second));
        System.out.println("Same object using ==: " + (first == second));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String first = sc.nextLine();
        System.out.print("Enter second string: ");
        String second = sc.nextLine();
        compareStrings(first, second);
        sc.close();
    }
}