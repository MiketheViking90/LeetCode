package seventeen.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNA {

    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();

        Set<String> seen = new HashSet<>();
        Set<String> repeat = new HashSet<>();
        for (int i = 10; i <= n; i++) {
            String sub = s.substring(i-10, i);
            if (seen.contains(sub)) {
                repeat.add(sub);
            } else {
                seen.add(sub);
            }
        }

        return new ArrayList<>(repeat);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        RepeatedDNA rdna = new RepeatedDNA();
        List<String> repeat = rdna.findRepeatedDnaSequences(s);
        System.out.println(repeat);
    }
}
