package palindrome.class_problems;

import java.util.Scanner;

public class PalindromeChecker {
    static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        String reversed = "";

        for (int i = chars.length - 1; i >= 0; i--) {
            reversed += chars[i];
        }
        return text.equals(reversed);
    }

    static String result(boolean palindrome) {
        return palindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: " + result(isPalindromeIterative(text)));
        System.out.println("Recursive: " + result(isPalindromeRecursive(text)));
        System.out.println("Array Reversal: " + result(isPalindromeArrayReversal(text)));
        sc.close();
    }
}
