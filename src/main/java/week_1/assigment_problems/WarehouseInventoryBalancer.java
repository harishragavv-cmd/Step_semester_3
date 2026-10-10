package week_1.assigment_problems;
import java.util.Scanner;

public class WarehouseInventoryBalancer {
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0, highest = Integer.MIN_VALUE, highestIndex = -1;
        String highestSection = "";
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestIndex = i;
                highestSection = "Section A";
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestIndex = i;
                highestSection = "Section B";
            }
        }
        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB
                + " | Status: " + status + " | Highest Quantity: " + highest
                + " (" + highestSection + ", Item " + (highestIndex + 1) + ")");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of item categories: ");
        int n = sc.nextInt();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Section A item " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Section B item " + (i + 1) + ": ");
            b[i] = sc.nextInt();
        }
        analyzeInventory(a, b);
        sc.close();
    }
}