package week_9.assignment_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostPopularCanteenOrder {

    // Returns {itemName, count}. Ties are resolved by first occurrence in orders.
    public static Object[] mostPopular(List<String> orders) {
        if (orders == null || orders.isEmpty()) {
            throw new IllegalArgumentException("Orders must contain at least one item");
        }

        Map<String, Integer> counts = new HashMap<>();
        for (String item : orders) {
            if (item == null) {
                throw new IllegalArgumentException("Order names cannot be null");
            }
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }

        String bestItem = orders.get(0);
        int bestCount = counts.get(bestItem);

        // Scanning the original order ensures the earliest item wins a tie.
        for (String item : orders) {
            int count = counts.get(item);
            if (count > bestCount) {
                bestItem = item;
                bestCount = count;
            }
        }

        return new Object[]{bestItem, bestCount};
    }

    public static void main(String[] args) {
        List<String> orders = Arrays.asList(
                "dosa", "idli", "vada", "dosa", "idli", "dosa", "tea");
        Object[] result = mostPopular(orders);
        System.out.println("(\"" + result[0] + "\", " + result[1] + ")");

        List<String> tieOrders = Arrays.asList("tea", "coffee", "coffee", "tea");
        Object[] tieResult = mostPopular(tieOrders);
        System.out.println("(\"" + tieResult[0] + "\", " + tieResult[1] + ")");
    }
}