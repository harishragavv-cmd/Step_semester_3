package week_1.class_problems;
import java.util.Scanner;

public class BmiTeamCalculator {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }
    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%d | %.2f | %.2f | %.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[3], weights = new double[3];
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Person " + (i + 1) + " height in meters: ");
            heights[i] = sc.nextDouble();
            System.out.print("Person " + (i + 1) + " weight in kg: ");
            weights[i] = sc.nextDouble();
        }
        printWellnessReport(heights, weights);
        sc.close();
    }
}