package week_9.assignment_problems;

import java.util.Arrays;
import java.util.List;

public class HotWeatherAlertWindows {

    public static int countAlerts(List<Integer> readings, int k, int threshold) {
        if (readings == null || k < 1 || k > readings.size()) {
            throw new IllegalArgumentException("k must be between 1 and the number of readings");
        }

        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += readings.get(i);
        }

        int alerts = windowSum >= (long) k * threshold ? 1 : 0;

        for (int i = k; i < readings.size(); i++) {
            windowSum += readings.get(i);
            windowSum -= readings.get(i - k);

            if (windowSum >= (long) k * threshold) {
                alerts++;
            }
        }

        return alerts;
    }

    public static void main(String[] args) {
        List<Integer> readings = Arrays.asList(2, 2, 2, 2, 5, 5, 5, 8);
        System.out.println(countAlerts(readings, 3, 4));
    }
}