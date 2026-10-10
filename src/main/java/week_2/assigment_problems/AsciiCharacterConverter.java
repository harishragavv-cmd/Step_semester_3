package week_2.assigment_problems;
import java.util.Scanner;

public class AsciiCharacterConverter {
    static void displayAscii(String text) {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            System.out.println(ch + " = " + (int) ch);
        }
    }
    static char convertAsciiToChar(int code) {
        return (char) code;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to display character codes: ");
        displayAscii(sc.nextLine());
        System.out.print("Enter an integer character code: ");
        int code = sc.nextInt();
        System.out.println("Character: " + convertAsciiToChar(code));
        sc.close();
    }
}