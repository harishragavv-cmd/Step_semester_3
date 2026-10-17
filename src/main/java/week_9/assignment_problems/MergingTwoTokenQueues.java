package week_9.assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergingTwoTokenQueues {

    public static List<Integer> mergeTokens(List<Integer> counterA, List<Integer> counterB) {
        if (counterA == null || counterB == null) {
            throw new IllegalArgumentException("Token lists cannot be null");
        }

        List<Integer> merged = new ArrayList<>(counterA.size() + counterB.size());
        int i = 0;
        int j = 0;

        while (i < counterA.size() && j < counterB.size()) {
            if (counterA.get(i) <= counterB.get(j)) {
                merged.add(counterA.get(i));
                i++;
            } else {
                merged.add(counterB.get(j));
                j++;
            }
        }

        while (i < counterA.size()) {
            merged.add(counterA.get(i++));
        }
        while (j < counterB.size()) {
            merged.add(counterB.get(j++));
        }

        return merged;
    }

    public static void main(String[] args) {
        System.out.println(mergeTokens(
                Arrays.asList(3, 8, 15, 20),
                Arrays.asList(5, 8, 12)));
        System.out.println(mergeTokens(
                new ArrayList<>(),
                Arrays.asList(4, 9)));
    }
}