package week_1.assigment_problems;
import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {
    static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            System.out.println("Signal log is empty");
            return;
        }
        char longestColor = signalLog.charAt(0), currentColor = signalLog.charAt(0);
        int longest = 1, current = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) current++;
            else {
                currentColor = signalLog.charAt(i);
                current = 1;
            }
            if (current > longest) {
                longest = current;
                longestColor = currentColor;
            }
        }
        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longest + " times");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter signal log: ");
        findLongestStreak(sc.nextLine().toUpperCase());
        sc.close();
    }
}