package week_2.class_problems;
import java.util.Scanner;

public class FileExtensionValidator {
    static String validateFileExtension(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot < 0 || dot == filename.length() - 1) return "Rejected - invalid file type";
        String extension = filename.substring(dot + 1);
        if (extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) return "Accepted";
        return "Rejected - invalid file type";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename: ");
        System.out.println(validateFileExtension(sc.nextLine().trim()));
        sc.close();
    }
}