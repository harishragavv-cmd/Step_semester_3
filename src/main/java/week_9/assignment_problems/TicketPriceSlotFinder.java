package week_9.assignment_problems;

import java.util.Arrays;
import java.util.List;

public class TicketPriceSlotFinder {

    // Returns the existing index, or the insertion index if newPrice is absent.
    public static int findSlot(List<Integer> prices, int newPrice) {
        if (prices == null) {
            throw new IllegalArgumentException("Prices cannot be null");
        }

        int low = 0;
        int high = prices.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int current = prices.get(mid);

            if (current == newPrice) {
                return mid;
            } else if (current < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(120, 150, 200, 260);
        System.out.println(findSlot(prices, 150));
        System.out.println(findSlot(prices, 210));
        System.out.println(findSlot(prices, 300));
    }
}