package eighteen.algo;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            int charIndex = S.charAt(i) - 'a';
            lastIndex[charIndex] = i;
        }

        List<Integer> partitions = new ArrayList<>();
        int anchor = 0, j = 0;
        for (int i = 0; i < S.length(); i++) {
            int charIndex = S.charAt(i) - 'a';
            j = Math.max(j, lastIndex[charIndex]);

            if (i == j) {
                partitions.add(j - anchor);
                anchor = i + 1;
            }
        }
        return partitions;
    }
}
