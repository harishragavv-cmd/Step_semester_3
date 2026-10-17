package week_9.class_problems;

import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSumUnsortedArray {

    public static boolean hasPairWithSumBruteForce(int[] nums, int target) {
        if (nums == null) throw new IllegalArgumentException("Input array is required");

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((long) nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null) throw new IllegalArgumentException("Input array is required");

        Set<Integer> seen = new HashSet<>();
        for (int value : nums) {
            long complement = (long) target - value;
            if (complement >= Integer.MIN_VALUE && complement <= Integer.MAX_VALUE
                    && seen.contains((int) complement)) {
                return true;
            }
            seen.add(value);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));
    }
}