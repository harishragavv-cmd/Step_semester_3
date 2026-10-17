package week_9.class_problems;

public class MaximizeAreaBetweenTwoBoundaries {

    // Two-pointer solution: O(n) time and O(1) additional space.
    public static long maxContainerArea(int[] heights) {
        if (heights == null) throw new IllegalArgumentException("Heights array is required");

        for (int height : heights) {
            if (height < 0) {
                throw new IllegalArgumentException("Heights cannot be negative");
            }
        }

        int left = 0;
        int right = heights.length - 1;
        long maxArea = 0;

        while (left < right) {
            long area = (long) Math.min(heights[left], heights[right]) * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }

            // The shorter wall limits the current area, so move that side inward.
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // Brute-force reference for complexity comparison: O(n^2) time, O(1) space.
    public static long maxContainerAreaBruteForce(int[] heights) {
        if (heights == null) throw new IllegalArgumentException("Heights array is required");

        long maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] < 0) throw new IllegalArgumentException("Heights cannot be negative");
            for (int j = i + 1; j < heights.length; j++) {
                long area = (long) Math.min(heights[i], heights[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(heights));
        System.out.println("Brute force: " + maxContainerAreaBruteForce(heights));
    }
}