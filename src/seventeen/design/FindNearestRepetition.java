package seventeen.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNearestRepetition {

    static String word = "";

    static int findDistance(String[] words) {
        Map<String, List<Integer>> wordToIndices = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> curIndicies = wordToIndices.getOrDefault(word, new ArrayList<>());
            curIndicies.add(i);
            wordToIndices.put(word, curIndicies);
        }

        int diff = words.length;
        for (Map.Entry<String, List<Integer>> entry : wordToIndices.entrySet()) {
            List<Integer> indices = entry.getValue();
            if (indices.size() >= 2) {
                int curDiff = getMinDiff(indices);
                if (curDiff < diff) {
                    diff = curDiff;
                    word = entry.getKey();
                }
            }
        }
        return diff;
    }

    private static int getMinDiff(List<Integer> indices) {
        int curMin = Integer.MAX_VALUE;
        for (int i=0; i<indices.size() - 1; i++) {
            int curIndex = indices.get(i);
            int nextIndex = indices.get(i+1);

            if ((nextIndex - curIndex) < curMin) {
                curMin = nextIndex - curIndex;
            }
        }
        return curMin;
    }

    public static void main(String[] args) {
        String[] words = "all the people the time all".split(" ");
        int diff = FindNearestRepetition.findDistance(words);
        System.out.println(diff);
        System.out.println(word);
    }
}
